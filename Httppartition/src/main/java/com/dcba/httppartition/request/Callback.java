package com.dcba.httppartition.request;

import com.dcba.httppartition.separate.Response;

public interface Callback<T> {
    void onResponse(Response<T> response);

    void onFailure(Response<T> response);
//    void onResponse(Call<T> call, Response<T> response);
//
//    void onFailure(Call<T> call, Throwable t);
}
