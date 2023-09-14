package com.paytend.amex.service;

import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author Sunny
 * @create 2023/9/13 09:30
 */
@Service
@Slf4j
public class Remote3dsServiceImpl {
   final private static OkHttpClient httpClient = new OkHttpClient();


    public void send(String merNo, String asn) {


    }


    private static void send(String url) {
        // 创建请求对象
        Request request = new Request.Builder()
                .url(url)
                .build();
        // 发送请求
        Response response = null;
        try {
            response = httpClient.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 处理响应
        if (response != null && response.isSuccessful()) {
            ResponseBody responseBody = response.body();
            if (responseBody != null) {
                // 将响应体转换为 JSON 字符串
                try {
                    String jsonResponse = responseBody.string();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // 使用 Jackson 将 JSON 字符串转换为 Java 对象


                // 处理 Java 对象

            }
        } else {
            System.err.println("HTTP Request failed with status code: " + response.code());
        }
    }

    public static void main(String[] args) {
        send("https://test.sinopayservice.com/GwThreeds/authentication/v1/supportedVersion");
    }


}
