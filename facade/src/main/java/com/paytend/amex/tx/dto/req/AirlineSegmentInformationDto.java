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
class AirlineSegmentInformationDto {

    String OrigAirportCd;
    String DestAirportCd;
    String AirportOnTktCnt;
    String RteAirportCd;
}
