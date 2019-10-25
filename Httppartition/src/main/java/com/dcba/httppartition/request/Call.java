package com.dcba.httppartition.request;

import com.dcba.httppartition.separate.Converter;
import com.dcba.httppartition.separate.Response;


public interface Call<T> extends Cloneable {
    Response<T> execute();

    void enqueue(Callback<T> callback);

    Call<T> setConverter1(Converter converter);

    Call<T> setConverter2(Converter converter);

    Call<T> setFullyCustomizeConverter(Converter converter);

    boolean isExecuted();

    void cancel();

    boolean isCanceled();

    Call<T> clone();

    /** The original HTTP request. */
//  Request request();
}
