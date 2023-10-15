package com.paytend.amex.ds.dto;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

/**
 * @author XX
 * 
 */
@Data
@Builder
public class SupportedVersionReqDto {
    String cardNo;

    String notificationURL;

    @Tolerate
    public SupportedVersionReqDto() {
    }

}
