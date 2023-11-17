package com.paytend.amex.tx.dto.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Sunny
 */
@AllArgsConstructor
@Getter
@Setter
class IATACarrierInformationDto {
    String IATACarrierCnt;
    String IATACarrierCd;
}
