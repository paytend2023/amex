package com.paytend.amex.facade.tx.dto.rsp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author XX
 * 
 */
@Getter
@Setter
@ToString
public class BatchResp {
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

    String version;
    String merId;
    String merTrmnlId;
    String batchID;
    String batchStatus;
    String batchStatusText;


}
