package com.paytend.ds.zf.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Sunny
 * @create 2023/9/15 10:17
 */
@Data
@Component
public class ZfDsConfig {
    private String supportedVersionUrl;
    private String merNo;
    private String publicKey;
}
