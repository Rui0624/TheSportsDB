package example.com.thesportsdb.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;

public class LiveDataCallAdapterFactory extends CallAdapter.Factory {


    /**
     * Perform number of checks and returns the Response type for the Retrofit requests
     *
     * CHECKS:
     * 1. returnType returns LiveData
     * 2. Type LiveData<T> is of ApiResponse.class
     * 3. Make sure ApiResponse is parameterzed
     * @param returnType
     * @param annotations
     * @param retrofit
     * @return
     */
    @Override
    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {

        //Check 1
        //returnType returns LiveData
        if (CallAdapter.Factory.getRawType(returnType) != LiveData.class){
            return null;
        }

        //Check 2
        //Type LiveData<T> is of ApiResponse.class
        Type observableType = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) returnType);

        //Check3
        //Make sure ApiResponse is parameterzed
        if (!(observableType instanceof ParameterizedType)){
            throw new IllegalArgumentException("resource must be parameterized");
        }

        Type bodyType = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) observableType);
        return new LiveDataCallAdapter<>(bodyType);
    }
}
