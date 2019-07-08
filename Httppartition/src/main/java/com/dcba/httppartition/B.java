package com.dcba.httppartition;

import com.dcba.httppartition.http.Body;
import com.dcba.httppartition.http.Field;
import com.dcba.httppartition.http.GET;
import com.dcba.httppartition.http.Query;
import com.dcba.httppartition.request.Call;


public interface B {

    @GET("http://abcd")
    Call<String> getH(@Query("name") @Field("sssss") String name, @Query("age") String age);
}
