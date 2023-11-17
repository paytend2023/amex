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
class PassengerNameDto {
    String PassLastNm;
    String PassFirstNm;
    String PassMidInitTxt;
    String PassTitleTxt;
}
