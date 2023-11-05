package com.paytend.amex.tx.dto.rsp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author XX
 */
@Getter
@Setter
@ToString
public class BatchRespDto extends BaseBatchRespDto {

    @Schema(description = "000 成功,参考 XML_GFSG_FINAL.pdf 9.1")
    private String batchStatus;

    @Schema(description = "状态描述")
    private String batchStatusText;

}
