package com.paytend.ds.zf.service;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Sunny
 * @create 2023/9/15 10:17
 */
@Data
@Component
@ConfigurationProperties(prefix = "ds.zf")
public class ZfDsConfig {
    private String supportedVersionUrl;
    private String merNo;
    private String publicKey;
}
