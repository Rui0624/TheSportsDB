package example.com.thesportsdb;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import androidx.annotation.NonNull;

public class AppExecutors {

    private static AppExecutors instance;

    private final Executor diskIO = Executors.newSingleThreadExecutor();

    private final Executor mainThreadExecutor = new MainThreadExecutor();

    public static AppExecutors getInstance(){

        if (instance == null)
            instance = new AppExecutors();

        return instance;
    }

    private final ScheduledExecutorService mNetworkIO = Executors.newScheduledThreadPool( 3 );

    public ScheduledExecutorService getNetworkIO(){

        return mNetworkIO;

    }

    public Executor getDiskIO() {
        return diskIO;
    }

    public Executor getMainThreadExecutor() {
        return mainThreadExecutor;
    }

    private static class MainThreadExecutor implements Executor{

        private Handler mainThreadHandler = new Handler(Looper.getMainLooper());

        @Override
        public void execute(@NonNull Runnable runnable) {
            mainThreadHandler.post(runnable);
        }
    }

}
