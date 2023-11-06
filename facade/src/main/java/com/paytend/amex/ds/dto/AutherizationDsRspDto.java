package com.paytend.amex.ds.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
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
 * <p>
 * 继续挑战
 * {
 * "threeDSServerTransID": "c660db07-d0fc-43f8-b1f9-58cd7ce07862",
 * "acsChallengeMandated": "N",
 * "acsReferenceNumber": "3DS_LOA_ACS_UPIT_000000_00001",
 * "acsTransID": "de720f51-969c-4957-9055-0b76138c29f6",
 * "acsURL": "https://test.sinopayservice.com/GwThreeds/server/v1/sendBrowserChallenge",
 * "authenticationType": "01",
 * "dsTransID": "c7294b6f-45b6-4350-bde7-2417dc8671b3",
 * "dsReferenceNumber": "3DS_LOA_DIS_CUCC_020100_00103",
 * "messageVersion": "2.2.0",
 * "transStatus": "C",
 * "messageType": "pArs",
 * "creqMessage": "eyJhY3NUcmFuc0lEIjoiZGU3MjBmNTEtOTY5Yy00OTU3LTkwNTUtMGI3NjEzOGMyOWY2IiwiY2hhbGxlbmdlV2luZG93U2l6ZSI6IjAyIiwibWVzc2FnZVR5cGUiOiJDUmVxIiwibWVzc2FnZVZlcnNpb24iOiIyLjIuMCIsInRocmVlRFNTZXJ2ZXJUcmFuc0lEIjoiYzY2MGRiMDctZDBmYy00M2Y4LWIxZjktNThjZDdjZTA3ODYyIn0="
 * }
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
 * <p>
 * 继续挑战
 * {
 * "threeDSServerTransID": "c660db07-d0fc-43f8-b1f9-58cd7ce07862",
 * "acsChallengeMandated": "N",
 * "acsReferenceNumber": "3DS_LOA_ACS_UPIT_000000_00001",
 * "acsTransID": "de720f51-969c-4957-9055-0b76138c29f6",
 * "acsURL": "https://test.sinopayservice.com/GwThreeds/server/v1/sendBrowserChallenge",
 * "authenticationType": "01",
 * "dsTransID": "c7294b6f-45b6-4350-bde7-2417dc8671b3",
 * "dsReferenceNumber": "3DS_LOA_DIS_CUCC_020100_00103",
 * "messageVersion": "2.2.0",
 * "transStatus": "C",
 * "messageType": "pArs",
 * "creqMessage": "eyJhY3NUcmFuc0lEIjoiZGU3MjBmNTEtOTY5Yy00OTU3LTkwNTUtMGI3NjEzOGMyOWY2IiwiY2hhbGxlbmdlV2luZG93U2l6ZSI6IjAyIiwibWVzc2FnZVR5cGUiOiJDUmVxIiwibWVzc2FnZVZlcnNpb24iOiIyLjIuMCIsInRocmVlRFNTZXJ2ZXJUcmFuc0lEIjoiYzY2MGRiMDctZDBmYy00M2Y4LWIxZjktNThjZDdjZTA3ODYyIn0="
 * }
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
 * <p>
 * 继续挑战
 * {
 * "threeDSServerTransID": "c660db07-d0fc-43f8-b1f9-58cd7ce07862",
 * "acsChallengeMandated": "N",
 * "acsReferenceNumber": "3DS_LOA_ACS_UPIT_000000_00001",
 * "acsTransID": "de720f51-969c-4957-9055-0b76138c29f6",
 * "acsURL": "https://test.sinopayservice.com/GwThreeds/server/v1/sendBrowserChallenge",
 * "authenticationType": "01",
 * "dsTransID": "c7294b6f-45b6-4350-bde7-2417dc8671b3",
 * "dsReferenceNumber": "3DS_LOA_DIS_CUCC_020100_00103",
 * "messageVersion": "2.2.0",
 * "transStatus": "C",
 * "messageType": "pArs",
 * "creqMessage": "eyJhY3NUcmFuc0lEIjoiZGU3MjBmNTEtOTY5Yy00OTU3LTkwNTUtMGI3NjEzOGMyOWY2IiwiY2hhbGxlbmdlV2luZG93U2l6ZSI6IjAyIiwibWVzc2FnZVR5cGUiOiJDUmVxIiwibWVzc2FnZVZlcnNpb24iOiIyLjIuMCIsInRocmVlRFNTZXJ2ZXJUcmFuc0lEIjoiYzY2MGRiMDctZDBmYy00M2Y4LWIxZjktNThjZDdjZTA3ODYyIn0="
 * }
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
 * <p>
 * 继续挑战
 * {
 * "threeDSServerTransID": "c660db07-d0fc-43f8-b1f9-58cd7ce07862",
 * "acsChallengeMandated": "N",
 * "acsReferenceNumber": "3DS_LOA_ACS_UPIT_000000_00001",
 * "acsTransID": "de720f51-969c-4957-9055-0b76138c29f6",
 * "acsURL": "https://test.sinopayservice.com/GwThreeds/server/v1/sendBrowserChallenge",
 * "authenticationType": "01",
 * "dsTransID": "c7294b6f-45b6-4350-bde7-2417dc8671b3",
 * "dsReferenceNumber": "3DS_LOA_DIS_CUCC_020100_00103",
 * "messageVersion": "2.2.0",
 * "transStatus": "C",
 * "messageType": "pArs",
 * "creqMessage": "eyJhY3NUcmFuc0lEIjoiZGU3MjBmNTEtOTY5Yy00OTU3LTkwNTUtMGI3NjEzOGMyOWY2IiwiY2hhbGxlbmdlV2luZG93U2l6ZSI6IjAyIiwibWVzc2FnZVR5cGUiOiJDUmVxIiwibWVzc2FnZVZlcnNpb24iOiIyLjIuMCIsInRocmVlRFNTZXJ2ZXJUcmFuc0lEIjoiYzY2MGRiMDctZDBmYy00M2Y4LWIxZjktNThjZDdjZTA3ODYyIn0="
 * }
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
 * <p>
 * 继续挑战
 * {
 * "threeDSServerTransID": "c660db07-d0fc-43f8-b1f9-58cd7ce07862",
 * "acsChallengeMandated": "N",
 * "acsReferenceNumber": "3DS_LOA_ACS_UPIT_000000_00001",
 * "acsTransID": "de720f51-969c-4957-9055-0b76138c29f6",
 * "acsURL": "https://test.sinopayservice.com/GwThreeds/server/v1/sendBrowserChallenge",
 * "authenticationType": "01",
 * "dsTransID": "c7294b6f-45b6-4350-bde7-2417dc8671b3",
 * "dsReferenceNumber": "3DS_LOA_DIS_CUCC_020100_00103",
 * "messageVersion": "2.2.0",
 * "transStatus": "C",
 * "messageType": "pArs",
 * "creqMessage": "eyJhY3NUcmFuc0lEIjoiZGU3MjBmNTEtOTY5Yy00OTU3LTkwNTUtMGI3NjEzOGMyOWY2IiwiY2hhbGxlbmdlV2luZG93U2l6ZSI6IjAyIiwibWVzc2FnZVR5cGUiOiJDUmVxIiwibWVzc2FnZVZlcnNpb24iOiIyLjIuMCIsInRocmVlRFNTZXJ2ZXJUcmFuc0lEIjoiYzY2MGRiMDctZDBmYy00M2Y4LWIxZjktNThjZDdjZTA3ODYyIn0="
 * }
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
 * <p>
 * 继续挑战
 * {
 * "threeDSServerTransID": "c660db07-d0fc-43f8-b1f9-58cd7ce07862",
 * "acsChallengeMandated": "N",
 * "acsReferenceNumber": "3DS_LOA_ACS_UPIT_000000_00001",
 * "acsTransID": "de720f51-969c-4957-9055-0b76138c29f6",
 * "acsURL": "https://test.sinopayservice.com/GwThreeds/server/v1/sendBrowserChallenge",
 * "authenticationType": "01",
 * "dsTransID": "c7294b6f-45b6-4350-bde7-2417dc8671b3",
 * "dsReferenceNumber": "3DS_LOA_DIS_CUCC_020100_00103",
 * "messageVersion": "2.2.0",
 * "transStatus": "C",
 * "messageType": "pArs",
 * "creqMessage": "eyJhY3NUcmFuc0lEIjoiZGU3MjBmNTEtOTY5Yy00OTU3LTkwNTUtMGI3NjEzOGMyOWY2IiwiY2hhbGxlbmdlV2luZG93U2l6ZSI6IjAyIiwibWVzc2FnZVR5cGUiOiJDUmVxIiwibWVzc2FnZVZlcnNpb24iOiIyLjIuMCIsInRocmVlRFNTZXJ2ZXJUcmFuc0lEIjoiYzY2MGRiMDctZDBmYy00M2Y4LWIxZjktNThjZDdjZTA3ODYyIn0="
 * }
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

/**
 * @author XX
 */
@Data
public class AutherizationDsRspDto extends BaseErrRspData {


    @Schema(description = "3ds server事务id")

    private String threeDSServerTransID;
    @Schema(description = "ACS挑战强制性指标\n" +
            "可选值：\n" +
            "• Y=挑战强制\n" +
            "• N=挑战不强制\t")
    private String acsChallengeMandated;
    @Schema(description = " 由EMVCo处指定的唯一标识符")

    private String acsReferenceNumber;

    @Schema(description = " acs事务id")
    private String acsTransID;

    @Schema(description = " ds事务id")
    private String dsTransID;
    private String dsReferenceNumber;

    @Schema(description = " 电子商务指标;ACS提供的特定于支付系统的值，用来指示试图验证持卡人身份的结果")
    private String eci;


    @Schema(description = " 消息版本")
    private String messageVersion;

    @Schema(description = " 交易状态\n" +
            "可选值：\n" +
            "• Y= 认证验证成功\n" +
            "• N = 未经身份验证/帐户未经验证；交易被拒绝\n" +
            "• U = 无法执行身份验证/帐户验证；技术或其他问题, 如ARes或RReq所示\n" +
            "• A = 尝试执行处理；未经过验证/验证，但提供了尝试验证/验证的证明\n" +
            "• C = 需要挑战；需要使用CReq/CRes进行其他身份验证\n" +
            "• D = 需要提出挑战；已确认已取消身份验证. 身份验证/验证，并请求不尝试授权\n" +
            "• R = 认证/帐户验证，发卡机构拒绝\n" +
            "• I = 仅限信息；3DS请求者挑战偏好")

    private String transStatus;

    @Schema(description = " 身份验证类型,表示发卡行将用于挑战持卡人的认证方法的类型\n" +
            "可选值：\n" +
            "• 01=静态\n" +
            "• 02=动态\n" +
            "• 03=OOB\n" +
            "• 04=解耦")
    private String authenticationType;



    @Schema(description = "Base64 URL编码的CReq消息，仅在浏览器流程中为挑战事务返回	")
    private String creqMessage;


    @Schema(description =  "acs挑战流地址	")
    private String acsURL;

    @Schema(description =  "授权交易需要的数据  和 eci 一起	")
    private String authenticationValue;

}
