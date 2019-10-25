package com.dcba.httppartition.test;

import com.dcba.httppartition.http.Body;
import com.dcba.httppartition.http.Field;
import com.dcba.httppartition.http.GET;
import com.dcba.httppartition.http.Param;
import com.dcba.httppartition.http.Query;
import com.dcba.httppartition.request.Call;


public interface B {

    @GET("http://abcd")
    Call<String> getH(@Param("name") String name, @Param("age") String age);
}
