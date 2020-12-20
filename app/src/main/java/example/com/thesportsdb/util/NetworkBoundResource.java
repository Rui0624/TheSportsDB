package example.com.thesportsdb.util;


import android.util.Log;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import example.com.thesportsdb.AppExecutors;
import example.com.thesportsdb.R;
import example.com.thesportsdb.requests.responses.ApiResponse;

//CacheObject: Type for the Resource data (database cache)
//RequestObject: Type for the API response (network request)
//link : https://developer.android.com/jetpack/docs/guide
public abstract class NetworkBoundResource<CacheObject, RequestObject> {
    private static final String TAG = "NetworkBoundResource";

    private AppExecutors appExecutors;
    private MediatorLiveData<Resource<CacheObject>> results = new MediatorLiveData<>();

    public NetworkBoundResource(AppExecutors appExecutors){

        this.appExecutors = appExecutors;

        init();
    }

    private void init(){

        //update LiveData for loading status
        results.setValue((Resource<CacheObject>) Resource.loading(null));

        //observe LiveData source from local database
        final LiveData<CacheObject> dbSource = loadFromDb();

        results.addSource( dbSource, cacheObject -> {

            results.removeSource(dbSource);

            if (shouldFetch(cacheObject)){
                //get data from network
                fetchDataFromNetwork(dbSource);
            }else {
                results.addSource( dbSource, cacheObject1 -> {
                    setValue(Resource.success(cacheObject1));
                } );
            }

        } );

    }

    /**
     * 1. observe local db
     * 2. if <condition/> query the network
     * 3. stop observing the local db
     * 4. insert new data into local db
     * 5. begin observing local db again to see the refreshed data from network
     * @param dbSource
     */
    private void fetchDataFromNetwork(final LiveData<CacheObject> dbSource){

        //update LiveData for loading status
        results.addSource( dbSource, cacheObject -> setValue(Resource.loading(cacheObject)) );

        final LiveData<ApiResponse<RequestObject>> apiResponse = createCall();

        results.addSource( apiResponse, requestObjectApiResponse -> {
            results.removeSource(dbSource);
            results.removeSource(apiResponse);


            if (requestObjectApiResponse instanceof ApiResponse.ApiSuccessResponse){
                //ApiSuccessResponse
                Log.d( TAG, "fetchDataFromNetwork: ApiSuccessResponse" );

                appExecutors.getDiskIO().execute( () -> {
                    //if call success, save response to local db
                    saveCallResult((RequestObject) processResponse((ApiResponse.ApiSuccessResponse) requestObjectApiResponse));

                    //set value in Main Thread
                    appExecutors.getMainThreadExecutor().execute( () -> {
                        results.addSource( loadFromDb(), cacheObject -> {
                            setValue(Resource.success(cacheObject));
                        } );
                    } );
                } );
            }else if (requestObjectApiResponse instanceof ApiResponse.ApiEmptyResponse){
                //ApiEmptyResponse
                Log.d( TAG, "fetchDataFromNetwork: ApiEmptyResponse" );
                appExecutors.getMainThreadExecutor().execute( () -> results.addSource( loadFromDb(),
                        cacheObject -> setValue(Resource.success(cacheObject)) ) );
            }else if (requestObjectApiResponse instanceof ApiResponse.ApiErrorResponse){
                //ApiErrorResponse
                Log.d( TAG, "fetchDataFromNetwork: ApiErrorResponse" );

                results.addSource( dbSource, new Observer<CacheObject>() {
                    @Override
                    public void onChanged(CacheObject cacheObject) {
                        setValue(Resource.error(((ApiResponse.ApiErrorResponse) requestObjectApiResponse).getErrorMessage(),cacheObject));
                    }
                } );
            }
        } );
    }


    private void setValue(Resource<CacheObject> newValue){

        if (results.getValue() != newValue){
            results.setValue(newValue);
        }

    }

    private CacheObject processResponse(ApiResponse.ApiSuccessResponse response){
        return (CacheObject) response.getBody();
    }
    // Called to save the result of the API response into the database.
    @WorkerThread
    protected abstract void saveCallResult(@NonNull RequestObject item);

    // Called with the data in the database to decide whether to fetch
    // potentially updated data from the network.
    @MainThread
    protected abstract boolean shouldFetch(@Nullable CacheObject data);

    // Called to get the cached data from the database.
    @NonNull @MainThread
    protected abstract LiveData<CacheObject> loadFromDb();

    // Called to create the API call.
    @NonNull @MainThread
    protected abstract LiveData<ApiResponse<RequestObject>> createCall();

    // Returns a LiveData object that represents the resource that's implemented
    // in the base class.
    public final LiveData<Resource<CacheObject>> getAsLiveData(){
        return results;
    };
}
