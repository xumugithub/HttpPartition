package com.dcba.httppartition.separate;

import com.dcba.httppartition.request.RequestResult;

public class ResponseConverter<T> {
    private Converter baseConverter;
    private Converter converter1;
    private Converter converter2;
    private Converter converter3;

    public Response<T> convert(RequestResult requestResult) {
        if (baseConverter != null) {
            requestResult.setResult(baseConverter.convert(requestResult.getResult()));
        }
        if (converter1 != null) {
            requestResult.setResult(converter1.convert(requestResult.getResult()));
        }
        if (converter2 != null) {
            requestResult.setResult(converter2.convert(requestResult.getResult()));
        }
        if (converter3 != null) {
            requestResult.setResult(converter3.convert(requestResult.getResult()));
        }
        Response response = new Response(requestResult.getCode(), (T) requestResult.getResult());
        return response;
    }

    public void setBaseConverter(Converter baseConverter) {
        this.baseConverter = baseConverter;
    }

    public void setConverter1(Converter converter1) {
        this.converter1 = converter1;
    }

    public void setConverter2(Converter converter2) {
        this.converter2 = converter2;
    }

    public void setConverter3(Converter converter3) {
        this.converter3 = converter3;
    }
}
