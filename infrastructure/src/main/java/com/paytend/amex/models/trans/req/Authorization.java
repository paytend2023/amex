package com.paytend.amex.models.trans.req;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.paytend.amex.models.trans.XmlRequest;
import io.aexp.api.client.core.utils.XmlUtility;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.experimental.Tolerate;

/**
 * @author gudongyang
 */
@SuperBuilder
@Getter
@Setter
@JacksonXmlRootElement(localName = "CardTransaction")
@JsonPropertyOrder(
        {
                "MsgTypId",
                "CardNbr",
                "TransProcCd",
                "TransAmt",
                "XmitTs",
                "TransTs",
                "CardEffDt",
                "AcqInstCtryCd",
                "PointOfServiceData",
                "FuncCd",
                "MsgRsnCd",
                "MerCtgyCd",
                "AprvCdLgth",
                "TransId",
                "AcqInstIdCd",
                "FwdInstIdCd",
                "CardTrack2Data",
                "RtrvRefNbr",
                "MerTrmnlId",
                "CardAcceptorIdentification",
                "CardAcceptorDetail",
                "CardTrack1Data",
                "AdditionalDataNational",
                "AdditionalDataPrivate",
                "TransCurrCd",
                "PINDataTxt",
                "ICCSDataTxt",
                "NatlUseData",
                "SecureAuthenticationSafeKey",
                "ValidationInformation",
                "ValidationInformation63",
                "KeyMgmtData",
                "ExtendedKeyMngtData",
                "PaymentAcctData",
                "AcptEnvData"
        })


public class Authorization extends BaseFields implements XmlRequest {


    /**
     * bit 62
     */
    @Setter(AccessLevel.NONE)
    private ValidationInformation62 ValidationInformation;
    /**
     * bit 63
     * todo
     */
    @JacksonXmlProperty(localName = "ValidationInformation")
    @Setter(AccessLevel.NONE)
    private VerificationInformation63 ValidationInformation63;


    @Tolerate
    public Authorization() {
    }

    public String toXMLString() {
        return XmlUtility.getInstance().getString(this);
    }


    @Override
    public String toXml() {
        String xml = XmlUtility.getInstance().getString(this);
        return "AuthorizationRequestParam=<?xml version=\"1.0\" encoding=\"utf-8\"?>" + XmlUtility.getInstance().formatXml(xml);
    }
}
