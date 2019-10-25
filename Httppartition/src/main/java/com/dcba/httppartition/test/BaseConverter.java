package com.dcba.httppartition.test;

import com.dcba.httppartition.separate.Converter;


public class BaseConverter<T> implements Converter<T> {
    @Override
    public T convert(Object value) {
        if (value instanceof String) {
            String json = (String) value;
            json = json.substring(json.indexOf("data"), json.length() - 1);
            /*try {
                JSONObject jo = new JSONObject(json);
                json = jo.getString("data");
            } catch (JSONException e) {
                e.printStackTrace();
            }*/
            return (T) json;
        }
        return (T) value;
    }
}
