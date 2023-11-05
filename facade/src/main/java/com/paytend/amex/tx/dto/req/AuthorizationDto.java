package com.paytend.amex.tx.dto.req;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.experimental.Tolerate;

/**
 * @author XIXI
 */
@SuperBuilder
@Getter
@Setter
@ToString(callSuper = true)
//@JacksonXmlRootElement(localName = "CardTransaction")
//@JsonPropertyOrder(
//        {
//                "MsgTypId",
//                "CardNbr",
//                "TransProcCd",
//                "TransAmt",
//                "XmitTs",
//                "TransTs",
//                "CardEffDt",
//                "AcqInstCtryCd",
//                "PointOfServiceData",
//                "FuncCd",
//                "MsgRsnCd",
//                "MerCtgyCd",
//                "AprvCdLgth",
//                "TransId",
//                "AcqInstIdCd",
//                "FwdInstIdCd",
//                "CardTrack2Data",
//                "RtrvRefNbr",
//                "MerTrmnlId",
//                "CardAcceptorIdentification",
//                "CardAcceptorDetail",
//                "CardTrack1Data",
//                "AdditionalDataNational",
//                "AdditionalDataPrivate",
//                "TransCurrCd",
//                "PINDataTxt",
//                "ICCSDataTxt",
//                "NatlUseData",
//                "SecureAuthenticationSafeKey",
//                "ValidationInformation",
//                "ValidationInformation63",
//                "KeyMgmtData",
//                "ExtendedKeyMngtData",
//                "PaymentAcctData",
//                "AcptEnvData"
//        })


@Schema(description = "授权结构体")
public class AuthorizationDto extends BaseFields  {


    /**
     * bit 62
     */
    @Setter(AccessLevel.NONE)
    private ValidationInformation62Dto ValidationInformation;
    /**
     * bit 63
     * todo
     */
    @Setter(AccessLevel.NONE)
    private VerificationInformation63Dto ValidationInformation63;


    @Tolerate
    public AuthorizationDto() {
    }

    public void setEcommerceAuthorizationValue(){
        this.setMsgTypId("1100");
    }


}
