package com.paytend.amex.tx.dto.req;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Tolerate;

/**
 * @author Sunny
 */
@Getter
@Builder
@Setter
@ToString
public class Psd2ExemptionsDto {
    String EuPsd2SecCorpPayInd;
    String AuthOutageInd;

    @Tolerate
    public Psd2ExemptionsDto() {
    }
}
