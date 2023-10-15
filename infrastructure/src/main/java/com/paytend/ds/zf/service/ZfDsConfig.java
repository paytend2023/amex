package com.paytend.ds.zf.service;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * @author XX
 * 
 */
@Data
@Component
@ConfigurationProperties("ds.zf")
@EnableConfigurationProperties
public class ZfDsConfig {
    private String supportedVersionUrl;
    private String merNo;
    private String publicKey;
    private String authUrl;
    private String resultUrl;

    //doSupportedVersion 回调地址
    private String versionNotifyUrl;
    //doAuth 回调地址
    private String authNotifyUrl;
}
