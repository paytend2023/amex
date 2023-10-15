package com.paytend.amex.tx.dto.req;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Tolerate;

/**
 * @author  XIXI
 */
@Getter
@Builder
@Setter
@ToString
public class AcptEnvDataDto {
    /**
     * 0 = Customer-Initiated
     * 1 = Merchant-Initiated
     */
    String InitPartyInd;
    Psd2ExemptionsDto psd2Exemptions;

    @Tolerate
    public AcptEnvDataDto() {
    }

}

/*
<AcptEnvData>
 <InitPartyInd></InitPartyInd>
 <Psd2Exemptions>
    <EuPsd2SecCorpPayInd>
    </EuPsd2SecCorpPayInd>
 </Psd2Exemptions>
</AcptEnvDat><
 */