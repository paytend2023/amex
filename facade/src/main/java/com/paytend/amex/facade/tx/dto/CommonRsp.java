package com.paytend.amex.facade.tx.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Sunny
 * @create 2023/9/11 20:36
 */
@Getter
@Setter
public class CommonRsp<T> {
    private String code;
    private String msg;
    private T data;
}
