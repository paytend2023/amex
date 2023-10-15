package com.paytend.amex.tx.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author  XIXI
 */

@Getter
@AllArgsConstructor
@Setter
public class AdditionalDataPrivate {

    AMEXExtendedPaymentIndicator AMEXExtendedPaymentIndicator;

    @Getter
    @AllArgsConstructor
    public static class AMEXExtendedPaymentIndicator {
        String PlanTypCd;
        String InstalPayNbr;
    }
}

/*
<AdditionalDataPrivate>
    <AMEXExtendedPaymentIndicator>
        <PlanTypCd></PlanTypCd>
        <InstalPayNbr></InstalPayNbr>
    </AMEXExtendedPaymentIndicator>
</AdditionalDataPrivate>
 */