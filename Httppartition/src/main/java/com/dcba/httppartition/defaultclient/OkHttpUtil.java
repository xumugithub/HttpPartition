package com.dcba.httppartition.defaultclient;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpUtil {
    private static final String CHARSET_NAME = "UTF-8";
    public static final String POST = "POST";
    public static final String GET = "GET";
    public static final String PUT = "PUT";
    public static final String DELETE = "DELETE";
    private static OkHttpUtil mInstance;
    private MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    //    private Request myRequest;
    private OkHttpClient mOkHttpClient;

    private static final String TAG = "OkHttpUtil";

    private OkHttpUtil() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(6000, TimeUnit.MILLISECONDS);
        mOkHttpClient = builder.build();
    }

    public static OkHttpUtil get() {
        if (mInstance == null) {
            synchronized (OkHttpUtil.class) {
                if (mInstance == null) {
                    mInstance = new OkHttpUtil();
                }
            }
        }
        return mInstance;
    }

    /**
     * 该不会开启异步线程。
     *
     * @param request
     * @return
     * @throws IOException
     */
    public Response execute(Request request) throws IOException {
        return mOkHttpClient.newCall(request).execute();
    }

    /**
     * 同步获取数据
     *
     * @param url
     * @param map
     * @param httpType
     * @return
     * @throws IOException
     */
    public Response getResponseFromServer(String url, Map<String, Object> map, String httpType) throws IOException {
        if (map == null) {
            map = new HashMap();
        }
        Request request = getRequest(url, map, httpType);
        Response response = execute(request);
        return response;
    }

    public Request getRequest(String url, Map<String, Object> map, String httpType) {
        if (map == null) {
            map = new HashMap();
        }
        Request.Builder requestbuilder = new Request.Builder();
        if (GET.equals(httpType)) {
            requestbuilder.get();
            StringBuilder sb = new StringBuilder();
            int i = 0;
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (i > 0 && i < map.size()) {
                    sb.append("&");
                }
                try {
                    String value = entry.getValue() == null ? "" : entry.getValue().toString();
                    sb.append(String.format("%s=%s", entry.getKey(), URLEncoder.encode(value, "utf-8")));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                i++;
            }
            if (map.size() != 0) {
                url = url + "?" + sb.toString();
            }
        } else {
            FormBody.Builder builder = new FormBody.Builder();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                builder.add(entry.getKey(), entry.getValue() + "");
            }
            RequestBody requestBody = builder.build();
            if (POST.equals(httpType)) {
                requestbuilder.post(requestBody);
            } else if (PUT.equals(httpType)) {
                requestbuilder.put(requestBody);
            } else if (DELETE.equals(httpType)) {
                requestbuilder.delete(requestBody);
            } else {
                requestbuilder.post(requestBody);
            }
        }
        requestbuilder.url(url);
        requestbuilder.header("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
        return requestbuilder.build();
    }

    public Request getRequest(String url, String jsonStr, String httpType) {
        Request.Builder requestbuilder = new Request.Builder();
        /*if (GET.equals(httpType)) {
            requestbuilder.get();
            url = url + "?" + jsonStr;
        } else {*/
        RequestBody requestBody = RequestBody.create(JSON, jsonStr);
        if (POST.equals(httpType)) {
            requestbuilder.post(requestBody);
        } else if (PUT.equals(httpType)) {
            requestbuilder.put(requestBody);
        } else if (DELETE.equals(httpType)) {
            requestbuilder.delete(requestBody);
        } else {
            requestbuilder.post(requestBody);
        }
//        }
        requestbuilder.url(url);
        requestbuilder.header("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
        return requestbuilder.build();
    }

}
