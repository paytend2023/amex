package com.paytend.amex.facade.ds.dto;

 import lombok.Builder;
import lombok.Data;
 import lombok.experimental.Tolerate;

/**
 * @author Sunny
 * @create 2023/9/15 09:13
 */
@Data
@Builder

public class SupportedVersionReqDto {
    String cardNo;

    String notificationURL;
    @Tolerate
  public   SupportedVersionReqDto(){}

}
