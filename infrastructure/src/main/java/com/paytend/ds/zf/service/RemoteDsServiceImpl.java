package com.paytend.ds.zf.service;

import cn.hutool.json.JSONUtil;
import com.paytend.amex.facade.ds.RemoteDsService;
import com.paytend.amex.facade.ds.dto.SupportedVersionReqDto;
import com.paytend.amex.facade.ds.dto.SupportedVersionRspDto;
import com.paytend.ds.zf.RSAUtils;

import com.paytend.exception.CallRemoteException;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Sunny
 * @create 2023/9/15 09:25
 */
@Service
@Slf4j
public class RemoteDsServiceImpl implements RemoteDsService {

    final private static OkHttpClient httpClient = new OkHttpClient();

    //   "https://test.sinopayservice.com/GwThreeds/authentication/v1/supportedVersion";
    private String supportedVersionUrl;
    private String merNo;
    private String publicKey;


    public RemoteDsServiceImpl(ZfDsConfig config) {
        this.merNo = config.getMerNo();
        this.supportedVersionUrl = config.getSupportedVersionUrl();
        this.publicKey = config.getPublicKey();
    }

    @Override
    public SupportedVersionRspDto doSupportedVersion(SupportedVersionReqDto req) {
        Map<String, String> headers = new HashMap<>();
        headers.put("merNo", merNo);
        String str =  JSONUtil.toJsonStr(req);
        String reqStr = null;
        try {
            reqStr = RSAUtils.encrypt(str, RSAUtils.getPublicKey(publicKey));
        } catch (Exception e) {
            log.info("req: {} {}", str, publicKey);
            throw new CallRemoteException("encdate err:", e);
        }
        String result = send(supportedVersionUrl, reqStr, headers);
        log.info("result:{}", result);
        return JSONUtil.toBean(result, SupportedVersionRspDto.class);
    }

    private static String send(String url, String body, Map<String, String> headers) {
        // 创建请求对象
        log.info("req:{}", body);
        RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"), body);
        Request request = new Request.Builder()
                .url(url)
                .headers(Headers.of(headers))
                .method("POST", requestBody)
                .build();

        // 发送请求
        Response response = null;
        try {
            response = httpClient.newCall(request).execute();
        } catch (IOException e) {
            throw new CallRemoteException("call zf exception:", e);
        }
        // 处理响应
        if (response == null || !response.isSuccessful()) {
            if (response != null) {
                throw new CallRemoteException("call zf exception:" + response.code(), null);
            }
            throw new CallRemoteException("response is null", null);
        }
        ResponseBody responseBody = response.body();
        // 将响应体转换为 JSON 字符串
        try {
            String ret = responseBody.string();
            return ret;
        } catch (IOException e) {
            throw new CallRemoteException("读取中付返回信息异常", e);
        }
        // 使用 Jackson 将 JSON 字符串转换为 Java 对象
        // 处理 Java 对象
    }
}
