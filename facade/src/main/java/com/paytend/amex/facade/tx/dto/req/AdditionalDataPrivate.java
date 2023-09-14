package com.paytend.amex.facade.tx.dto.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author gudongyang
 */

@Getter
@AllArgsConstructor
@Setter
@ToString
public class AdditionalDataPrivate {

    AMEXExtendedPaymentIndicator amexExtendedPaymentIndicator;

    @Getter
    @AllArgsConstructor
    public static class AMEXExtendedPaymentIndicator {
        String planTypCd;
        String instalPayNbr;
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