package com.dcba.httppartition.separate;

public class Response<T> {
    private int code;
    private T body;

    public Response(int code, T body) {
        this.code = code;
        this.body = body;
    }

    public int code() {
        return code;
    }

    public T body() {
        return body;
    }

}
