package com.paytend.amex.facade.ds.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author Sunny
 * @create 2023/9/18 12:52
 */

/**
 * {
 *     "threeDSServerTransID":"393f99b9-466b-4543-8243-dd35c92c0080",
 *     "acsChallengeMandated":"N",
 *     "acsReferenceNumber":"3DS_LOA_ACS_UPIT_000000_00001",
 *     "acsTransID":"35169020-e8ff-42fb-8dc5-8bd6491e817e",
 *     "dsTransID":"17973862-dd8a-4713-b044-a4684a9b066c",
 *     "dsReferenceNumber":"3DS_LOA_DIS_CUCC_020100_00103",
 *     "eci":"05",
 *     "messageVersion":"2.2.0",
 *     "transStatus":"Y",
 */

/**
 * "threeDSServerTransID":"21603f1f-d502-437d-98eb-0ccf67040057",
 * "errorCode":"201",
 * "errorComponent":"S",
 * "errorDescription":"threeDSServerTransID does not exist or has already been used",
 * "errorDetail":"3DS Server",
 * "errorMessageType":"AReq",
 * "messageType":"Erro",
 * "messageVersion":"2.2.0"
 */

@Data
public class AutherizationDsRspDto extends BaseErrRspData {


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
