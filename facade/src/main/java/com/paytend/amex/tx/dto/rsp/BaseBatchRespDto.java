package com.paytend.amex.tx.dto.rsp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Sunny
 */
@Getter
@Setter
public class BaseBatchRespDto {
    /**
     * <BatchAdminResponse>
     * <Version>12010000</Version>
     * <MerId>8127921740</MerId>
     * <MerTrmnlId>80000011</MerTrmnlId>
     * <BatchID>100005</BatchID>
     * <BatchStatus>001</BatchStatus>
     * <BatchStatusText>Close</BatchStatusText>
     * </BatchAdminResponse>
     */

    @Schema(description = "同请求")
    protected String version;
    @Schema(description = "同请求")
    protected String merId;
    @Schema(description = "同请求")
    protected String merTrmnlId;
    @Schema(description = "同请求")
    protected String batchID;
}
