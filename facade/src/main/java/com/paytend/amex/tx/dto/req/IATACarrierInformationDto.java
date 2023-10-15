package com.paytend.amex.tx.dto.req;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Sunny
 */
@AllArgsConstructor
@Getter
class IATACarrierInformationDto {
    String IATACarrierCnt;
    String IATACarrierCd;
}
