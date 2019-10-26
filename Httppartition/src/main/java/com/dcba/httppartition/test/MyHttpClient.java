package com.dcba.httppartition.test;

import com.dcba.httppartition.request.RequestInfo;
import com.dcba.httppartition.request.RequestResult;
import com.dcba.httppartition.separate.HttpClient;

import java.util.Map;

public class MyHttpClient implements HttpClient {

    @Override
    public RequestResult sendRequest(RequestInfo requestParam) {
        System.out.println("开始发出请求-----url:" + requestParam.getUrl());
        System.out.println("开始发出请求-----类型:" + requestParam.getHttpType());
        Map<String, Object> map = requestParam.getParams();
        System.out.println("参数为");
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        System.out.println("请求中...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String json = "{\"code\":\"0\",\"data\":\"[{\"xm\":\"小明\",\"nl\":28}]\"}";
        return new RequestResult(200, json);
    }
}
