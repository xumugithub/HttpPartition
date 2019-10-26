package com.example.httppartitiontest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.dcba.httppartition.defaultclient.HPOkHttpClient;
import com.dcba.httppartition.request.Callback;
import com.dcba.httppartition.separate.HttpPartition;
import com.dcba.httppartition.separate.Response;
import com.dcba.httppartition.test.B;
import com.dcba.httppartition.test.MyHttpClient;
import com.example.httppartitiontest.tools.UrlApi;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tv_text = findViewById(R.id.tv_text);
        HttpPartition httpPartition = new HttpPartition.Builder().baseUrl("http://wthrcdn.etouch.cn")
                .setHttpClient(new HPOkHttpClient()).build();
//        httpPartition.setBaseConverter(new BaseConverter());
        UrlApi urlApi = httpPartition.create(UrlApi.class);

        urlApi.getTianqi("101010100").enqueue(new Callback<String>() {
            @Override
            public void onResponse(Response<String> response) {
                System.out.println("66666666666666666666 code:"+response.code()+"   "+response.body());
                tv_text.setText(response.body());
            }

            @Override
            public void onFailure(Response<String> response) {

            }
        });

        System.out.println("wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
    }
}
