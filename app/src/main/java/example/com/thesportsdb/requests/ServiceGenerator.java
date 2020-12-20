package example.com.thesportsdb.requests;

import java.util.concurrent.TimeUnit;

import example.com.thesportsdb.BuildConfig;
import example.com.thesportsdb.util.LiveDataCallAdapterFactory;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static example.com.thesportsdb.util.Constants.CONNECTION_TIMEOUT;
import static example.com.thesportsdb.util.Constants.READ_TIMEOUT;
import static example.com.thesportsdb.util.Constants.WRITE_TIMEOUT;

public class ServiceGenerator {

    private static OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            .retryOnConnectionFailure(false)
            .build();

    private static Retrofit.Builder retrofitBuilder =
            new Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .client(okHttpClient)
                    .addCallAdapterFactory(new LiveDataCallAdapterFactory() )
                    .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();

    private static SportDBApi sSportDBApi = retrofit.create( SportDBApi.class);

    public static SportDBApi getSportDBApi(){
        return sSportDBApi;
    }

}
