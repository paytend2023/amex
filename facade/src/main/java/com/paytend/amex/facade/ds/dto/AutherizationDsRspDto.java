package com.paytend.amex.facade.ds.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author Sunny
 * @create 2023/9/18 12:52
 */
@Data
public class AutherizationDsRspDto extends BaseErrRspData {
    /**
     * {
     *     "threeDSServerTransID": "099d4eb0-5ea8-460a-bb66-dc6be9593422",
     *     "acsChallengeMandated": "N",
     *     "acsReferenceNumber": "3DS_LOA_ACS_UPIT_000000_00001",
     *     "acsTransID": "ac655716-b0e7-4bc8-b5be-f4fc52072638",
     *     "dsTransID": "b4a9b8c2-b953-4834-8711-718f99298619",
     *     "dsReferenceNumber": "3DS_LOA_DIS_CUCC_020100_00103",
     *     "eci": "07",
     *     "messageVersion": "2.2.0",
     *     "transStatus": "U",
     */

  private   String threeDSServerTransID;
  private   String acsChallengeMandated;
  private   String acsReferenceNumber;
  private   String acsTransID;
  private   String dsTransID;
  private   String dsReferenceNumber;
  private   String eci;
  private   String messageVersion;
  private   String transStatus;
}
