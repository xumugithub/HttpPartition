package com.dcba.httppartition.request;

import com.dcba.httppartition.separate.Converter;
import com.dcba.httppartition.separate.HttpClient;
import com.dcba.httppartition.separate.Response;
import com.dcba.httppartition.separate.ResponseConverter;
import com.dcba.httppartition.separate.ThreadFactory;


public class HttpCall<T> implements Call<T> {
    private HttpClient httpClient;
    private RequestInfo requestInfo;
    private ResponseConverter<T> responseConverter;

    public HttpCall(HttpClient httpClient, RequestInfo requestInfo, ResponseConverter responseConverter) {
        this.httpClient = httpClient;
        this.requestInfo = requestInfo;
        this.responseConverter = responseConverter;
    }

    @Override
    public Response<T> execute() {
        RequestResult requestResult = httpClient.sendRequest(requestInfo);
        return responseConverter.convert(requestResult);
    }

    @Override
    public Call<T> setConverter1(Converter converter) {
        responseConverter.setConverter1(converter);
        return this;
    }

    @Override
    public Call<T> setConverter2(Converter converter) {
        responseConverter.setConverter2(converter);
        return this;
    }

    @Override
    public Call<T> setFullyCustomizeConverter(Converter converter) {
        responseConverter.setFullyCustomizeConverter(converter);
        return this;
    }

    @Override
    public void enqueue(final Callback<T> callback) {
        ThreadFactory.get().execute(new Runnable() {
            @Override
            public void run() {
                final Response response = execute();
                ThreadFactory.get().runInMainThread(new Runnable() {
                    @Override
                    public void run() {
                        int code = response.code();
                        if (code >= 200 && code < 300) {
                            callback.onResponse(response);
                        } else {
                            callback.onFailure(response);
                        }
                    }
                });
            }
        });
    }

    @Override
    public boolean isExecuted() {
        return false;
    }

    @Override
    public void cancel() {

    }

    @Override
    public boolean isCanceled() {
        return false;
    }

    @Override
    public Call clone() {
        return null;
    }
}
