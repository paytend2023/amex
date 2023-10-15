package com.paytend.amex.tx.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 交易请求头
 *
 * @author XX
 */
@Setter
@Getter
@Builder
public class TxHeader {
    private String origin;
    private String country;
    private String region;
    private String merchNbr;
    private String rtInd;
    private String message;


    public Map<String, String> convertToMap() {
        Map<String, String> ret = new HashMap<>(6);
        ret.put("origin", origin);
        ret.put("country", country);
        ret.put("region", region);
        ret.put("merchNbr", merchNbr);
        ret.put("rtInd", rtInd);
        ret.put("message", message);
        return ret;
    }
}
