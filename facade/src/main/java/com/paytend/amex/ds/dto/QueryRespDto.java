package com.paytend.amex.ds.dto;

import lombok.Data;
import lombok.ToString;

/**
 * @author XX
 * 
 */
@Data
@ToString
public class QueryRespDto {
    private String code;
    private String message;

    private QueryRspDataDto data;

}
