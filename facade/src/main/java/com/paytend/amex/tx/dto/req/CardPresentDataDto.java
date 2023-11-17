package com.paytend.amex.tx.dto.req;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Sunny
 */
@Builder
@Getter
@Setter
public class CardPresentDataDto {
    String VersionNo;
    String GoodSoldProdCd;
}
