package com.paytend.ds.zf.service;

import cn.hutool.json.JSONUtil;
import com.paytend.amex.facade.ds.RemoteDsService;
import com.paytend.amex.facade.ds.dto.*;
import com.paytend.ds.zf.RSAUtils;

import com.paytend.exception.CallRemoteException;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.apache.commons.logging.Log;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author Sunny
 * @create 2023/9/15 09:25
 */
@Service
@Slf4j
public class RemoteDsServiceImpl implements RemoteDsService {

    final private static OkHttpClient HTTP_CLIENT = new OkHttpClient();

    //   "https://test.sinopayservice.com/GwThreeds/authentication/v1/supportedVersion";
    private final String supportedVersionUrl;
    //    https://test.sinopayservice.com/GwThreeds/authentication/v1/auth
    private final String authUrl;
    private final String merNo;
    private final String publicKey;
    //    https://test.sinopayservice.com/GwThreeds/challenge/v1/{threeDSServerTransID}/result
    private final String resultUrl;


    public RemoteDsServiceImpl(ZfDsConfig config) {
        log.info("init config:{}", config);
        this.merNo = config.getMerNo();
        this.supportedVersionUrl = config.getSupportedVersionUrl();
        this.publicKey = config.getPublicKey();
        this.authUrl = config.getAuthUrl();
        this.resultUrl = config.getResultUrl();
    }


    @Override
    public AutherizationDsRspDto doAuthentication(AutherizationDsReqDto auth, String threeDsServerTransId) {
        Map<String, String> headers = new HashMap<>();
        headers.put("merNo", merNo);
        headers.put("threeDSServerTransID", Optional.of(threeDsServerTransId).get());
        return innerReq(auth, headers, AutherizationDsRspDto.class, authUrl);
    }

    public QueryRespDto doQuery(String threeDsServerTransId) {
        return innerGet(String.format(resultUrl, threeDsServerTransId));
    }

    private QueryRespDto innerGet(String url) {
        log.info("query:{}", url);
        Request request = new Request.Builder().url(url).build();
        Call call = HTTP_CLIENT.newCall(request);
        try {
            Response response = call.execute();
            String jsonString = response.body().string();
            log.info("response {}", response.body().string());
            return JSONUtil.toBean(jsonString, QueryRespDto.class);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public SupportedVersionRspDto doSupportedVersion(SupportedVersionReqDto req) {
        Map<String, String> headers = new HashMap<>();
        headers.put("merNo", merNo);
        return innerReq(req, headers, SupportedVersionRspDto.class, supportedVersionUrl);
    }

    private <T, R> R innerReq(T req, Map<String, String> headers, Class<R> returnType, String url) {
        String str = JSONUtil.toJsonStr(req);
        String reqStr = null;
        try {
            reqStr = RSAUtils.encrypt(str, RSAUtils.getPublicKey(publicKey));
        } catch (Exception e) {
            log.info("req: {} {}", str, publicKey);
            throw new CallRemoteException("encdate err:", e);
        }
        String result = send(url, reqStr, headers);
        log.info("result:{}", result);
        return JSONUtil.toBean(result, returnType);
    }

    private static String send(String url, String body, Map<String, String> headers) {
        // 创建请求对象
        log.info("req:{},header:{}", body, headers);
        RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"), body);
        Request request = new Request.Builder()
                .url(url)
                .headers(Headers.of(headers))
                .method("POST", requestBody)
                .build();

        // 发送请求
        Response response = null;
        try {
            response = HTTP_CLIENT.newCall(request).execute();
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
