package com.dcba.httppartition.separate;

public class Response<T> {
    private String code;
    private T body;

    public Response(String code, T body) {
        this.code = code;
        this.body = body;
    }

    public String code() {
        return code;
    }

    public T body() {
        return body;
    }

}
