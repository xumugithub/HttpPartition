package com.dcba.httppartition.separate;


import com.dcba.httppartition.request.RequestInfo;
import com.dcba.httppartition.request.RequestResult;

public interface HttpClient {

    public RequestResult sendRequest(RequestInfo requestParam);
}
