package com.paytend.amex.tx.dto.rsp;

import lombok.Data;

/**
 * @author Sunny
 */
@Data
public class DataCaptureRspDto extends BatchRespDto {
    String refNumber;
}
