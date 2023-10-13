package com.paytend.amex.facade.tx.dto.req;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * <OriginalDataElements>
 * <MsgTypId></MsgTypId>
 * <MerSysTraceAudNbr> </MerSysTraceAudNbr>
 * <TransTs></TransTs>
 * <AcqInstIdCd></AcqInstIdCd>
 * </OriginalDataElements>
 *
 * @author XX
 * 
 */
@Setter
@Getter
@Builder
public class OriginalDataElements {
    String MsgTypId;
    String MerSysTraceAudNbr;
    String TransTs;
    String AcqInstIdCd;
}
