package com.dcba.httppartition.separate;


public interface Converter<T> {

    public T convert(Object value);

}
