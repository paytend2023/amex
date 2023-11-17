package com.paytend.amex.tx.dto.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Sunny
 */
@Getter
@AllArgsConstructor
@Setter
public class AMEXExtendedPaymentIndicatorDto {
    String PlanTypCd;
    String InstalPayNbr;
}
