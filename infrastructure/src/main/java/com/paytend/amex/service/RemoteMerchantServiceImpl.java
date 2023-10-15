package com.paytend.amex.service;

import com.paytend.amex.mch.dto.req.SePayLoadRequest;
import com.paytend.amex.mch.dto.resp.SellerResponse;
import com.paytend.amex.mch.remote.RemoteMerchantService;
import com.paytend.amex.tx.TransCommUtils;
import io.aexp.api.client.core.configuration.ConfigurationKeys;
import io.aexp.api.client.core.configuration.ConfigurationProvider;
import io.aexp.api.client.core.configuration.PropertiesConfigurationProvider;
import io.aexp.api.client.core.security.authentication.AuthProvider;
import io.aexp.api.client.core.security.authentication.HmacAuthBuilder;
import io.aexp.api.client.core.utils.JsonUtility;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;


/**
 * @author xixi
 */
@Slf4j
@Service

public class RemoteMerchantServiceImpl implements RemoteMerchantService {

    private static final MediaType JSON_MEDIA_TYPE = MediaType.parse("application/json; charset=utf-8");

    @Value("${amex.merchant.url: }")
    private String url;

    @Value("${amex.merchant.client_key: }")
    private String clientKey;

    @Value("${amex.merchant.client_secret: }")
    private String clientSecret;
    private ConfigurationProvider configurationProvider;

    @PostConstruct
    public void postConstruct() {
        log.info("  \nurl: {}\n  clientKey:{}\n  clientSecret:{} ", url, clientKey, clientSecret);
        PropertiesConfigurationProvider provider = new PropertiesConfigurationProvider();
        Properties props = new Properties();
        provider.setProperties(props);
        props.setProperty(ConfigurationKeys.CLIENT_KEY, clientKey);
        props.setProperty(ConfigurationKeys.CLIENT_SECRET, clientSecret);
        configurationProvider = provider;
    }


    @Override
    public SellerResponse reportMerchants(SePayLoadRequest sePayLoadRequest) throws IOException {
        AuthProvider authProvider = HmacAuthBuilder.getBuilder().setConfiguration(configurationProvider).build();
        String method = "POST";
        JsonUtility jsonUtility = JsonUtility.getInstance();
        String xml = jsonUtility.getXml(sePayLoadRequest);
        String newJson = jsonUtility.getString(jsonUtility.xml2Obj(xml, com.paytend.amex.seller.req.SePayLoadRequest.class));
        log.info("req:{}", newJson);
        String respStr = submitPostRequest(url, authProvider.generateAuthHeaders(newJson, url, method), newJson);
        return jsonUtility.getObject(respStr, SellerResponse.class);
    }

    private String submitPostRequest(String url, Map<String, String> headers, String payload) throws IOException {
        HttpUrl httpUrl = HttpUrl.parse(url);
        HttpUrl.Builder httpUrlBuilder = httpUrl.newBuilder();
        Request.Builder builder = new Request.Builder()
                .url(httpUrlBuilder.build())
                .post(RequestBody.create(JSON_MEDIA_TYPE, payload));
        for (Map.Entry<String, String> header : headers.entrySet()) {
            log.info("header->> {} {}", header.getKey(), header.getValue());
            builder.addHeader(header.getKey(), header.getValue());
        }
        Request request = builder.build();
        Response response = TransCommUtils.get().newCall(request).execute();
        String tmp = response.body().string();
        log.info(" respCode:{} Response: {} ", response.code(), tmp);
        return tmp;
    }
}

