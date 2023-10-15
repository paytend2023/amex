package com.paytend.amex.tx;


import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.X509TrustManager;
import java.io.File;
import java.io.FileInputStream;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author xixi
 */
@Slf4j
@Component
public class TransCommUtils {

    private static TransCommUtils COMM;
    final private static Map<String, String> HEADERS = new HashMap<>();
    final private static Character LOCK = '1';
    private static OkHttpClient httpClient;


    @Value("${amex.auth.key_store: }")
    private String keyStore;

    @Value("${amex.auth.passwd: }")
    private String pwd;

    public TransCommUtils() {

    }

    @PostConstruct

    public void init() {
        log.info("keyStore: {}, password: {} ", keyStore, pwd);
        KeyStore keyStore = null;
        try {
            keyStore = loadKeyStore(this.keyStore, pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }

        SSLContext sslContext = null;
        try {
            sslContext = createSSLContext(keyStore, pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        httpClient = new OkHttpClient.Builder().sslSocketFactory(sslContext.getSocketFactory(), new X509TrustManager() {
                    @Override
                    public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

                    }

                    @Override
                    public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

                    }

                    @Override
                    public X509Certificate[] getAcceptedIssuers() {
                        return new X509Certificate[0];
                    }
                }).connectTimeout(60, TimeUnit.SECONDS).readTimeout(60, TimeUnit.SECONDS)
                .build();

        HEADERS.put("Content-Type", "plain/text");
        HEADERS.put("User-Agent", "Application;");
        HEADERS.put("Cache-Control", "no-cache");
        HEADERS.put("Connection", "Keep-Alive");
    }


    public static TransCommUtils getInstance() {
        if (COMM == null) {
            synchronized (LOCK) {
                COMM = new TransCommUtils();
            }
        }
        return COMM;
    }

    public static OkHttpClient get(){
        return httpClient;
    }


     private static final MediaType TEXT_MEDIA_TYPE = MediaType.parse("plain/text;");

    public String sendXml(String url, XmlRequest xmlRequest, Map<String, String> customHeaders) throws Exception {
        HttpUrl httpUrl = HttpUrl.parse(url);
        HttpUrl.Builder httpUrlBuilder = httpUrl.newBuilder();
        String xml = xmlRequest.toXml();
        log.info("url:{}\n {} ", url, xml);
        Request.Builder builder = new Request.Builder()
                .url(httpUrlBuilder.build())
                .post(RequestBody.create(TEXT_MEDIA_TYPE, xml));
        for (Map.Entry<String, String> header : HEADERS.entrySet()) {
            log.info(header.getKey() + " = " + header.getValue());
            builder.addHeader(header.getKey(), header.getValue());
        }
        for (Map.Entry<String, String> header : customHeaders.entrySet()) {
            log.info((header.getKey() + " = " + header.getValue()));
            builder.addHeader(header.getKey(), header.getValue());
        }

        Request request = builder.build();
        Response response = httpClient.newCall(request).execute();
        return response.body().string();
    }

    private static KeyStore loadKeyStore(String keystorePath, String keystorePassword) throws Exception {
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        File file = ResourceUtils.getFile("classpath:" + keystorePath);
        keyStore.load(new FileInputStream(file), keystorePassword.toCharArray());
        return keyStore;
    }

    private static SSLContext createSSLContext(KeyStore keyStore, String keyPassword)
            throws NoSuchAlgorithmException, UnrecoverableKeyException, KeyStoreException, KeyManagementException {
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(keyStore, keyPassword.toCharArray());
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyManagerFactory.getKeyManagers(), null, null);
        return sslContext;
    }
}
