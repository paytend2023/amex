package com.paytend.amex.tx.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * 交易请求头
 *
 * @author XX
 * 
 */
@Setter
@Getter
@Builder
public class TxHeader {
    private String origin;
    private String country;
    private String region;
    private String merchNbr;
}
