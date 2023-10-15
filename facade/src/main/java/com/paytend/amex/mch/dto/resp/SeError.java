package com.paytend.amex.mch.dto.resp;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Tolerate;

/**
 * @author  XIXI
 */
@Builder
@Getter
@ToString
public class SeError {


    /**
     * err_cd
     * string, max: 10 REQUIRED
     * This alphanumeric field contains an error code.
     */
    String errCd;
    /**
     * err_msg
     * string, max: 100 REQUIRED
     * This alphanumeric field contains an error message.
     */
    String errMsg;

    @Tolerate
    public SeError() {
    }
}
