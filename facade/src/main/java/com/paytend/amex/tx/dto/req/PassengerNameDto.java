package com.paytend.amex.tx.dto.req;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Sunny
 */
@AllArgsConstructor
@Getter
class PassengerNameDto {
    String PassLastNm;
    String PassFirstNm;
    String PassMidInitTxt;
    String PassTitleTxt;
}
