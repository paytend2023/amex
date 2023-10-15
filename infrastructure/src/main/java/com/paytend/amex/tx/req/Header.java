package com.paytend.amex.tx.req;

import lombok.Builder;

import java.util.HashMap;
import java.util.Map;

/**
 * @author
 */
@Builder
public class Header {

    private String origin;
    private String country;
    private String region;
    //  SE Number / Merchant Number
    private String merchNbr;

    //读配置文件
    private String message;
    private String rtInd;
    private String host;


    public Map<String, String> convert2Map() {
        Map<String, String> headers = new HashMap<>(7);
        headers.put("Origin", origin);
        headers.put("Country", country);
        headers.put("region", region);
        headers.put("Message", message);
        headers.put("MerchNbr", merchNbr);
        headers.put("RtInd", rtInd);
        headers.put("Host", host);
        return headers;
    }

    public static Map<String, String> defaultHeaders() {
        return Header.builder()
                .origin("Paytend")
                .country("276")
                .region("EMEA")
                .message("XML GCAG")
                .merchNbr("3285220521")
                .rtInd("050")
                .host("https://qwww318.americanexpress.com/IPPayments/inter/CardAuthorization.do")
                .build().convert2Map();
    }
}
