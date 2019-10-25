package com.dcba.httppartition.separate;

public class ThreadFactory {
    private static ThreadFactory instance;


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


}
