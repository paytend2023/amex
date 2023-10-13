package com.paytend.amex.facade.tx.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author XX
 * 
 */
@Getter
@Setter
@AllArgsConstructor
public class CommonRsp<T> {
    private String code;
    private String msg;
    private T data;


    public static <T> CommonRsp<T> OK(T obj) {
        return new CommonRsp<>("00", "处理成功!", obj);
    }
}
