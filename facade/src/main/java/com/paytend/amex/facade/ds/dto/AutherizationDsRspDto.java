package com.paytend.amex.facade.ds.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author XX
 * 
 * <p>
 * 成功
 * {
 * "threeDSServerTransID":"393f99b9-466b-4543-8243-dd35c92c0080",
 * "acsChallengeMandated":"N",
 * "acsReferenceNumber":"3DS_LOA_ACS_UPIT_000000_00001",
 * "acsTransID":"35169020-e8ff-42fb-8dc5-8bd6491e817e",
 * "dsTransID":"17973862-dd8a-4713-b044-a4684a9b066c",
 * "dsReferenceNumber":"3DS_LOA_DIS_CUCC_020100_00103",
 * "eci":"05",
 * "messageVersion":"2.2.0",
 * "transStatus":"Y",
 * <p>
 * 失败
 * "threeDSServerTransID":"21603f1f-d502-437d-98eb-0ccf67040057",
 * "errorCode":"201",
 * "errorComponent":"S",
 * "errorDescription":"threeDSServerTransID does not exist or has already been used",
 * "errorDetail":"3DS Server",
 * "errorMessageType":"AReq",
 * "messageType":"Erro",
 * "messageVersion":"2.2.0"
 */


/**
 * 成功
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
 * 失败
 * "threeDSServerTransID":"21603f1f-d502-437d-98eb-0ccf67040057",
 * "errorCode":"201",
 * "errorComponent":"S",
 * "errorDescription":"threeDSServerTransID does not exist or has already been used",
 * "errorDetail":"3DS Server",
 * "errorMessageType":"AReq",
 * "messageType":"Erro",
 * "messageVersion":"2.2.0"
 */

/**
 * 继续挑战
 * {
 * 	"threeDSServerTransID": "c660db07-d0fc-43f8-b1f9-58cd7ce07862",
 * 	"acsChallengeMandated": "N",
 * 	"acsReferenceNumber": "3DS_LOA_ACS_UPIT_000000_00001",
 * 	"acsTransID": "de720f51-969c-4957-9055-0b76138c29f6",
 * 	"acsURL": "https://test.sinopayservice.com/GwThreeds/server/v1/sendBrowserChallenge",
 * 	"authenticationType": "01",
 * 	"dsTransID": "c7294b6f-45b6-4350-bde7-2417dc8671b3",
 * 	"dsReferenceNumber": "3DS_LOA_DIS_CUCC_020100_00103",
 * 	"messageVersion": "2.2.0",
 * 	"transStatus": "C",
 * 	"messageType": "pArs",
 * 	"creqMessage": "eyJhY3NUcmFuc0lEIjoiZGU3MjBmNTEtOTY5Yy00OTU3LTkwNTUtMGI3NjEzOGMyOWY2IiwiY2hhbGxlbmdlV2luZG93U2l6ZSI6IjAyIiwibWVzc2FnZVR5cGUiOiJDUmVxIiwibWVzc2FnZVZlcnNpb24iOiIyLjIuMCIsInRocmVlRFNTZXJ2ZXJUcmFuc0lEIjoiYzY2MGRiMDctZDBmYy00M2Y4LWIxZjktNThjZDdjZTA3ODYyIn0="
 * }
 */

@Data
public class AutherizationDsRspDto extends BaseErrRspData {


    private String threeDSServerTransID;
    private String acsChallengeMandated;
    private String acsReferenceNumber;
    private String acsTransID;
    private String dsTransID;
    private String dsReferenceNumber;
    private String eci;
    private String messageVersion;
    private String transStatus;
    private String authenticationType;
    private String creqMessage;
    private String acsURL;

}
