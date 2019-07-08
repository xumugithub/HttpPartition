package com.dcba.httppartition.request;

import java.util.Map;

public class RequestInfo {
    public static final String GET = "GET";
    public static final String POST = "POST";
    private String httpType;
    private String url_firsthalf;//url前半截
    private String url_secondhalf;//url后半截
    private Map<String, Object> params;

    public RequestInfo() {
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public String getUrl() {
        if (url_firsthalf.endsWith("/")) {
            url_firsthalf.substring(0, url_firsthalf.length() - 1);
        }
        if (!url_secondhalf.startsWith("/")) {
            url_secondhalf = "/" + url_secondhalf;
        }
        return url_firsthalf + url_secondhalf;
    }

    public String getHttpType() {
        return httpType;
    }

    public void setHttpType(String httpType) {
        this.httpType = httpType;
    }

    public void setUrl_firsthalf(String url_firsthalf) {
        this.url_firsthalf = url_firsthalf;
    }

    public void setUrl_secondhalf(String url_secondhalf) {
        this.url_secondhalf = url_secondhalf;
    }
}
