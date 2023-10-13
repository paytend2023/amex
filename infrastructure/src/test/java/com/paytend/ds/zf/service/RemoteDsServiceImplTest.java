package com.paytend.ds.zf.service;

import cn.hutool.core.date.DateUtil;

import com.paytend.amex.facade.ds.dto.AutherizationDsReqDto;
import com.paytend.amex.facade.ds.dto.SupportedVersionReqDto;
import com.paytend.amex.facade.ds.dto.SupportedVersionRspDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * @author XX
 * 
 */
class RemoteDsServiceImplTest {

    RemoteDsServiceImpl service;

    @BeforeEach
    void init() {
        ZfDsConfig config = new ZfDsConfig();
        config.setSupportedVersionUrl("https://test.sinopayservice.com/GwThreeds/authentication/v1/supportedVersion");
        config.setAuthUrl("https://test.sinopayservice.com/GwThreeds/authentication/v1/auth");
//        config.setResultUrl("https://test.sinopayservice.com/GwThreeds/challenge/v1/{threeDSServerTransID}/result");
        config.setResultUrl("https://test.sinopayservice.com/GwThreeds/challenge/v1/%s/result");
        config.setMerNo("1002");
        config.setPublicKey("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA7Def2tyTs3sWg1HiLD3l/ECjdk0aVqIZaOScMYpcN4CINJ2G8egWVqCzGkBemg1l2gQMoSc7WeW1KZA5t4Qsr1H2IJRe8c26oeqf3hlJac0iWI55CN6Qslbzu0xSu2RqXfKrIiRYtu166unPS7zS6jffjViRzd1LBpiFjrc2w9p8KPMdBhzfUwDfFotPMBbwzW2Yt7PdVVtq1M3QiIpjm7SVVL8p5Js9UO4sctG4SAiXtmvTQM3fV019Zi4WGRi+L4c7aOOnotzcHr4meM/8QRnF1nLPIo6VVnMbuvR1FCarVvOpeVHyoEivRN8w9BhlATZP3Iftga+/IccUFWYutQIDAQAB");
        service = new RemoteDsServiceImpl(config);
    }

    @Test
    void doAuthentication() {
        SupportedVersionRspDto requestedVersionRsp = supportedVersion();
        AutherizationDsReqDto autherizationDsReqDto = AutherizationDsReqDto.builder()
                .acctNumber("375987000169792")
                .acctType("01")
                .acquirerBIN("123456")
                .acquirerMerchantID("123456789")
                .browserAcceptHeader("firefox")
                .browserIP("127.0.0.1")
                .browserJavaEnabled("false")
                .browserJavascriptEnabled("true")
                .browserLanguage("cn")
                .browserScreenHeight("1024")
                .browserScreenWidth("1024")
                .browserColorDepth("1024")

                .browserTZ("UTC+8")
                .browserUserAgent("xxxxx")
                .cardExpiryDate("3308")

                .deviceChannel("02")
                .mcc("7996")
                .merchantName("xxx store")
                .messageCategory("01")
                .messageVersion("2.2.1")
                .notificationURL("www.baidu.com")
                .notificationURL("1000")
                .purchaseAmount("1000")

                .purchaseCurrency("978")
                .merchantCountryCode("978")

                .purchaseDate(DateUtil.format(new Date(), "yyyyMMddHHmmss"))
                .threeRIInd("11")
                .recurringExpiry(DateUtil.format(new Date(), "yyyyMMdd"))
                .threeDSCompInd("Y")
                .threeDSRequestorAuthenticationInd("01")
                .threeDSRequestorDecMaxTime("10000")
                .transType("01")
                .build();
        String threeDsServerTransId = requestedVersionRsp.getThreeDSServerTransID();
        service.doAuthentication(autherizationDsReqDto, threeDsServerTransId);
    }


    @Test
    void doSupportedVersion() {

        supportedVersion();
    }

    private SupportedVersionRspDto supportedVersion() {
        SupportedVersionReqDto req = SupportedVersionReqDto.builder()
                .cardNo("375987000169792")
                .notificationURL("https://www.baidu.com")
                .build();
        return service.doSupportedVersion(req);

    }


    @Test
    void doQuery() {
        service.doQuery("0e304a1a-805e-4db9-9ced-94bdf62221de");
        service.doQuery("0e304a1a-805e-4db9-9ced");
    }
}