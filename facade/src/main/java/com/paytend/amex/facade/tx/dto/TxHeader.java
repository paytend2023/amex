package com.paytend.amex.facade.tx.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * 交易请求头
 *
 * @author Sunny
 * @create 2023/9/11 21:51
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
