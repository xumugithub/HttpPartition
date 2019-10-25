package com.dcba.httppartition.request;

import com.dcba.httppartition.http.Body;
import com.dcba.httppartition.http.GET;
import com.dcba.httppartition.http.POST;
import com.dcba.httppartition.http.Param;
import com.dcba.httppartition.http.Query;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class RequestFactory {

    public static RequestInfo createRequestInfo(Method method, Object[] args) {
        RequestInfo requestInfo = new RequestInfo();
        Annotation[] annotations = method.getAnnotations();
        for (Annotation an : annotations) {
            if (an instanceof GET) {
                requestInfo.setHttpType(RequestInfo.GET);
                requestInfo.setUrl_secondhalf(((GET) an).value());
            } else if (an instanceof POST) {
                requestInfo.setHttpType(RequestInfo.POST);
                requestInfo.setUrl_secondhalf(((POST) an).value());
            }
        }

        Map<String, Object> map = new HashMap<>();
        Annotation[][] parameterAnnotationsArray = method.getParameterAnnotations();
        for (int i = 0; i < parameterAnnotationsArray.length; i++) {
            Object obj = args[i];
            Annotation[] anarr = parameterAnnotationsArray[i];
            for (Annotation an : anarr) {
                if (an instanceof Param) {
                    String value = ((Param) an).value();
                    map.put(value, obj);
                } else if (an instanceof Body) {
//                    value = ((POST) an).value();
                }
            }
        }
        requestInfo.setParams(map);
        return requestInfo;
    }
}
