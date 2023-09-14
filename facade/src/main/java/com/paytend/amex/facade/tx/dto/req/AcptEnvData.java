package com.paytend.amex.facade.tx.dto.req;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Tolerate;

/**
 * @author gudongyang
 */
@Getter
@Builder
@Setter
@ToString
public class AcptEnvData {
    /**
     * 0 = Customer-Initiated
     * 1 = Merchant-Initiated
     */
    String initPartyInd;

    Psd2Exemptions psd2Exemptions;

    @Tolerate
    public AcptEnvData() {
    }

    @Getter
    @Builder
    @ToString
    public static class Psd2Exemptions {
        String euPsd2SecCorpPayInd;
        String authOutageInd;

        @Tolerate
        public Psd2Exemptions() {
        }
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