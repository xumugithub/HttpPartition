package com.dcba.httppartition.defaultclient;

import com.dcba.httppartition.request.RequestInfo;
import com.dcba.httppartition.request.RequestResult;
import com.dcba.httppartition.separate.HttpClient;

import java.io.IOException;

import okhttp3.Response;

public class HPOkHttpClient implements HttpClient {

    @Override
    public RequestResult sendRequest(RequestInfo requestParam) {
        RequestResult requestResult = new RequestResult();
        try {
            Response okresponse = OkHttpUtil.get().getResponseFromServer(requestParam.getUrl(),
                    requestParam.getParams(), requestParam.getHttpType());
            requestResult.setCode(okresponse.code());
            requestResult.setResult(okresponse.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return requestResult;
    }
}
