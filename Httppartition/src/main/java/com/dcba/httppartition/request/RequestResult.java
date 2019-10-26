package com.dcba.httppartition.request;

public class RequestResult {
    private int code;
    private Object result;

    public RequestResult() {
    }

    public RequestResult(int code, Object result) {
        this.code = code;
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
