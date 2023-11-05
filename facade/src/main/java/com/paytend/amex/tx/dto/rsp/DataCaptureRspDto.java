package com.paytend.amex.tx.dto.rsp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author Sunny
 */
@Data
public class DataCaptureRspDto extends BaseBatchRespDto {
    String refNumber;

    @Schema(description = "000 DataCaptureRequest request successful(其余为失败) ,参考 XML_GFSG_FINAL.pdf 9.0")
    private String statusCode;

    @Schema(description = "状态描述" )
    private String statusText;
}
