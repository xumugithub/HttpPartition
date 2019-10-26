package com.dcba.httppartition;

import com.dcba.httppartition.request.Callback;
import com.dcba.httppartition.separate.HttpPartition;
import com.dcba.httppartition.separate.Response;
import com.dcba.httppartition.test.B;
import com.dcba.httppartition.test.BaseConverter;
import com.dcba.httppartition.test.HConverter1;
import com.dcba.httppartition.test.MyHttpClient;

import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        HttpPartition httpPartition = new HttpPartition.Builder().baseUrl("http://127.0.0.1")
                .setHttpClient(new MyHttpClient()).build();
        httpPartition.setBaseConverter(new BaseConverter());
        B b = httpPartition.create(B.class);
        /*String json = b.getH("张三", "15").execute().body();
        System.out.println("请求返回的数据:" + json);
        System.out.println("再次发出请求。。。");*/
//        String json2 = b.getH("李四", "17").setConverter1(new HConverter1()).execute().body();
//        System.out.println("请求返回的数据:" + json2);

        b.getH("奇拉拉", "20").enqueue(new Callback<String>() {
            @Override
            public void onResponse(Response<String> response) {
                System.out.println("奇拉拉返回:" + response.body());
            }

            @Override
            public void onFailure(Response<String> response) {

            }
        });

        System.out.println("test执行完s");
    }
}