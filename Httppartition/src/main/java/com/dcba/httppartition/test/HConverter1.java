package com.dcba.httppartition.test;

import com.dcba.httppartition.separate.Converter;

public class HConverter1 implements Converter {
    @Override
    public Object convert(Object value) {
        String va= (String) value;
        return va.substring(va.indexOf("xm")+5, va.indexOf("xm")+7);
    }
}
