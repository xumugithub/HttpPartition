package com.dcba.httppartition.separate;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadFactory {
    private static ThreadFactory instance;
    private ExecutorService cacheThreadPool = new ThreadPoolExecutor(3, 10,
            7L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(30));//创建线程池

    private Handler handler = new Handler(Looper.getMainLooper());

    private ThreadFactory() {
    }

    public static ThreadFactory get() {
        if (instance == null) {
            synchronized (ThreadFactory.class) {
                if (instance == null) {
                    instance = new ThreadFactory();
                }
            }
        }
        return instance;
    }

    public void execute(Runnable runnable) {
        cacheThreadPool.execute(runnable);
    }

    public void runInMainThread(Runnable runnable) {
        handler.post(runnable);
    }
}
