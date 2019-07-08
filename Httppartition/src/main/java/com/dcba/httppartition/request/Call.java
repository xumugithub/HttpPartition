package com.dcba.httppartition.request;

import com.dcba.httppartition.separate.Response;


public interface Call<T> extends Cloneable {
    Response<T> execute();

    void enqueue(Callback<T> callback);

    boolean isExecuted();

    void cancel();

    boolean isCanceled();

    Call<T> clone();

    /** The original HTTP request. */
//  Request request();
}
