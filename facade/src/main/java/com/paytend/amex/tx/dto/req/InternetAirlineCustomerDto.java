package com.paytend.amex.tx.dto.req;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

/**
 * @author  XIXI
 */
@Builder
@Getter
@Setter
public class InternetAirlineCustomerDto {
    String DprtDt;

    PassengerNameDto PassengerName;

    AirlineSegmentInformationDto AirlineSegmentInformation;

    IATACarrierInformationDto IATACarrierInformation;

    String FareBasisCd1;
    String FareBasisCd2;
    String FareBasisCd3;
    String FareBasisCd4;
    String PassInPartyCnt;
    String CustIPAddr;
    String CustEmailAddr;

    @Tolerate
    public InternetAirlineCustomerDto() {
    }


}
