package com.paytend.amex.ds.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

/**
 * @author XX
 */
@Data
@Builder
public class SupportedVersionReqDto {
    @Schema(description = "卡号")
    String cardNo;
    @Schema(description = "回调地址,主要用于接收来自ACS表单提交后的信息")
    String notificationURL;

    @Tolerate
    public SupportedVersionReqDto() {
    }

}
