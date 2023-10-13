package com.paytend.ds.zf.service;

import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paytend.amex.facade.ds.dto.AutherizationDsReqDto;
import com.paytend.amex.facade.ds.dto.AutherizationDsRspDto;
import com.paytend.amex.facade.ds.dto.SupportedVersionReqDto;
import com.paytend.amex.facade.ds.dto.SupportedVersionRspDto;
import com.paytend.amex.ds.remote.RemoteDsService;
import com.paytend.amex.ds.dto.QueryRespDto;

import com.paytend.ds.zf.RSAUtils;

import com.paytend.exception.CallRemoteException;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author XX
 */
@Service
@Slf4j
public class RemoteDsServiceImpl implements RemoteDsService {
    final private static OkHttpClient HTTP_CLIENT = new OkHttpClient();
    @Resource
    private ObjectMapper objectMapper;

    //   "https://test.sinopayservice.com/GwThreeds/authentication/v1/supportedVersion";
    private final String supportedVersionUrl;
    //    https://test.sinopayservice.com/GwThreeds/authentication/v1/auth
    private final String authUrl;
    private final String merNo;
    private final String publicKey;
    //    https://test.sinopayservice.com/GwThreeds/challenge/v1/{threeDSServerTransID}/result
    private final String resultUrl;

    private final String versionNotifyUrl;
    private final String authNotifyUrl;


    public RemoteDsServiceImpl(ZfDsConfig config) {
        log.info("init config:{}", config);
        this.merNo = config.getMerNo();
        this.supportedVersionUrl = config.getSupportedVersionUrl();
        this.publicKey = config.getPublicKey();
        this.authUrl = config.getAuthUrl();
        this.resultUrl = config.getResultUrl();
        this.versionNotifyUrl = config.getVersionNotifyUrl();
        this.authNotifyUrl = config.getAuthNotifyUrl();
    }


     public AutherizationDsRspDto doAuthentication(AutherizationDsReqDto auth, String threeDsServerTransId) {
        Map<String, String> headers = new HashMap<>();
        headers.put("merNo", merNo);
        headers.put("threeDSServerTransID", Optional.of(threeDsServerTransId).get());
        auth.setNotificationURL(createNotifyUrl(authNotifyUrl, auth.getNotificationURL()));
        return innerReq(auth, headers, AutherizationDsRspDto.class, authUrl);
    }

    private String formatPath(String url) {
        String tmp = Optional.of(url).get();
        return tmp.endsWith("/") ? tmp : tmp + "/";
    }

    public QueryRespDto doQuery(String threeDsServerTransId) {
        return innerGet(String.format(resultUrl, threeDsServerTransId));
    }

    private QueryRespDto innerGet(String url) {
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


    String createNotifyUrl(String baseNotifyUrl, String urlPathInfo) {
        if (Optional.of(urlPathInfo).get().startsWith("http")) {
            throw new RuntimeException("通知地址错误" + formatPath(baseNotifyUrl) + urlPathInfo);
        }
        return formatPath(baseNotifyUrl) + urlPathInfo;
    }

    @Override
    public SupportedVersionRspDto doSupportedVersion(@Validated SupportedVersionReqDto req) {
        assert req.getCardNo() != null;
        Map<String, String> headers = new HashMap<>();
        req.setNotificationURL(createNotifyUrl(versionNotifyUrl, req.getCardNo()));
        headers.put("merNo", merNo);
        return innerReq(req, headers, SupportedVersionRspDto.class, supportedVersionUrl);
    }

    private <T, R> R innerReq(T req, Map<String, String> headers, Class<R> returnType, String url) {
        String str;
        try {
            str = objectMapper.writeValueAsString(req);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        log.info("request json: [{}] [{}]", url, str);
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
            return responseBody.string();
        } catch (IOException e) {
            throw new CallRemoteException("读取中付返回信息异常", e);
        }
        // 使用 Jackson 将 JSON 字符串转换为 Java 对象
        // 处理 Java 对象
    }


}
