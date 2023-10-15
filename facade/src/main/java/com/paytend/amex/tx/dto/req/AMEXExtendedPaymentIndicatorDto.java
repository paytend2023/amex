package com.paytend.amex.tx.dto.req;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Sunny
 */
@Getter
@AllArgsConstructor
public class AMEXExtendedPaymentIndicatorDto {
    String PlanTypCd;
    String InstalPayNbr;
}
