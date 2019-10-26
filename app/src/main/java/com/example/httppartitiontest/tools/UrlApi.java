package com.example.httppartitiontest.tools;

import com.dcba.httppartition.http.GET;
import com.dcba.httppartition.http.Param;
import com.dcba.httppartition.request.Call;

public interface UrlApi {

    @GET("/weather_mini")
    Call<String> getTianqi(@Param("citykey") String citykey);//citykey=101010100
}
