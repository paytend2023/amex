package com.paytend.amex.tx.dto.req;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.experimental.Tolerate;

/**
 * @author  XIXI
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


//implements XmlRequest
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
//    @JacksonXmlProperty(localName = "ValidationInformation")
    @Setter(AccessLevel.NONE)
    private VerificationInformation63Dto ValidationInformation63;


    @Tolerate
    public AuthorizationDto() {
    }

//    public String toXMLString() {
//        return XmlUtility.getInstance().getString(this);
//    }


//    @Override
//    public String toXml() {
//        String xml = XmlUtility.getInstance().getString(this);
//        return "AuthorizationRequestParam=<?xml version=\"1.0\" encoding=\"utf-8\"?>" + XmlUtility.getInstance().formatXml(xml);
//    }
}
