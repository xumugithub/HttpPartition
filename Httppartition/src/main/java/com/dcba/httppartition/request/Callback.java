package com.dcba.httppartition.request;

import com.dcba.httppartition.separate.Response;

public interface Callback<T> {
    void onResponse(Call<T> call, Response<T> response);

    void onFailure(Call<T> call, Throwable t);
}
