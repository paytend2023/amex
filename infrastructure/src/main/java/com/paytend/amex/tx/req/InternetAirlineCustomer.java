package com.paytend.amex.tx.req;

import lombok.AllArgsConstructor;
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
public class InternetAirlineCustomer {
    String DprtDt;

    PassengerName PassengerName;

    AirlineSegmentInformation AirlineSegmentInformation;

    IATACarrierInformation IATACarrierInformation;

    String FareBasisCd1;
    String FareBasisCd2;
    String FareBasisCd3;
    String FareBasisCd4;
    String PassInPartyCnt;
    String CustIPAddr;
    String CustEmailAddr;

    @Tolerate
    public InternetAirlineCustomer() {
    }

    @AllArgsConstructor
    @Getter
    class PassengerName {
        String PassLastNm;
        String PassFirstNm;
        String PassMidInitTxt;
        String PassTitleTxt;
    }

    @AllArgsConstructor
    @Getter
    class AirlineSegmentInformation {

        String OrigAirportCd;
        String DestAirportCd;
        String AirportOnTktCnt;
        String RteAirportCd;
    }

    @AllArgsConstructor
    @Getter
    class IATACarrierInformation {
        String IATACarrierCnt;
        String IATACarrierCd;
    }


}
