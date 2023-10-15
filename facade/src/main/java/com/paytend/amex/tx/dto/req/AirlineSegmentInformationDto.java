package com.paytend.amex.tx.dto.req;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Sunny
 */
@AllArgsConstructor
@Getter
class AirlineSegmentInformationDto {

    String OrigAirportCd;
    String DestAirportCd;
    String AirportOnTktCnt;
    String RteAirportCd;
}
