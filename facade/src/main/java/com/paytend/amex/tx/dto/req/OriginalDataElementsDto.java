package com.paytend.amex.tx.dto.req;

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
public class OriginalDataElementsDto {
    String MsgTypId;
    String MerSysTraceAudNbr;
    String TransTs;
    String AcqInstIdCd;
}
