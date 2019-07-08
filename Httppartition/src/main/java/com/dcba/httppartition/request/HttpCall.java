package com.dcba.httppartition.request;

import com.dcba.httppartition.separate.HttpClient;
import com.dcba.httppartition.separate.Response;
import com.dcba.httppartition.separate.ResponseConverter;

import java.text.ParseException;


public class HttpCall<T> implements Call<T> {
    private HttpClient httpClient;
    private RequestInfo requestInfo;
    private ResponseConverter responseConverter;

    public HttpCall(HttpClient httpClient, RequestInfo requestInfo, ResponseConverter responseConverter) {
        this.httpClient = httpClient;
        this.requestInfo = requestInfo;
        this.responseConverter = responseConverter;
    }

    @Override
    public Response execute() {
        RequestResult requestResult = httpClient.sendRequest(requestInfo);
        return responseConverter.convert(requestResult);
    }

    @Override
    public void enqueue(Callback callback) {

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
