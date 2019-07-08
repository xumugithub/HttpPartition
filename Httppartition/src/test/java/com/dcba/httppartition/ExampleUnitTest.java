package com.dcba.httppartition;

import com.dcba.httppartition.separate.HttpPartition;

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
        String json = httpPartition.create(B.class).getH("张三", "15").execute().body();
        System.out.println("请求返回的数据:"+json);
    }
}