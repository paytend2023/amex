package com.paytend.ds.zf.service;

import com.paytend.amex.facade.ds.dto.SupportedVersionReqDto;
import org.junit.jupiter.api.Test;

/**
 * @author Sunny
 * @create 2023/9/15 09:57
 */
class DsServiceImplTest {

    @Test
    void doSupportedVersion() {
        ZfDsConfig config = new ZfDsConfig();
        config.setSupportedVersionUrl("https://test.sinopayservice.com/GwThreeds/authentication/v1/supportedVersion");
        config.setMerNo("1002");
        config.setPublicKey("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA7Def2tyTs3sWg1HiLD3l/ECjdk0aVqIZaOScMYpcN4CINJ2G8egWVqCzGkBemg1l2gQMoSc7WeW1KZA5t4Qsr1H2IJRe8c26oeqf3hlJac0iWI55CN6Qslbzu0xSu2RqXfKrIiRYtu166unPS7zS6jffjViRzd1LBpiFjrc2w9p8KPMdBhzfUwDfFotPMBbwzW2Yt7PdVVtq1M3QiIpjm7SVVL8p5Js9UO4sctG4SAiXtmvTQM3fV019Zi4WGRi+L4c7aOOnotzcHr4meM/8QRnF1nLPIo6VVnMbuvR1FCarVvOpeVHyoEivRN8w9BhlATZP3Iftga+/IccUFWYutQIDAQAB");
        RemoteDsServiceImpl service = new RemoteDsServiceImpl(config);
        SupportedVersionReqDto req = SupportedVersionReqDto.builder()
                .cardNo("375987000169792")
                .notificationURL("https://www.baidu.com")
                .build();
        service.doSupportedVersion(req);
    }
}