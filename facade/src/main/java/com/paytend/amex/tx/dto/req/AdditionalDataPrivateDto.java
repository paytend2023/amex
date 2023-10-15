package com.paytend.amex.tx.dto.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author  XIXI
 */

@Getter
@AllArgsConstructor
@Setter
public class AdditionalDataPrivateDto {

    AMEXExtendedPaymentIndicatorDto AMEXExtendedPaymentIndicator;

}

/*
<AdditionalDataPrivate>
    <AMEXExtendedPaymentIndicator>
        <PlanTypCd></PlanTypCd>
        <InstalPayNbr></InstalPayNbr>
    </AMEXExtendedPaymentIndicator>
</AdditionalDataPrivate>
 */