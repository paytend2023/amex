package com.paytend.amex;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author XX
 */
@Getter
@Setter
@AllArgsConstructor

@Schema(description = "前置返回结构体")
public class CommonRsp<T> {
    @Schema(description = "返回码 00 成功", type = "string")
    private String code;
    @Schema(description = "描述", type = "string")
    private String msg;

    @Schema(description = "转发的结构体,实际返回的内容", type = "object")
    private T data;


    public static <T> CommonRsp<T> OK(T obj) {
        return new CommonRsp<>("00", "处理成功!", obj);
    }
}
