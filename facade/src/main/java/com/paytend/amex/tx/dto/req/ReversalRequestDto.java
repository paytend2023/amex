package com.paytend.amex.tx.dto.req;

//import cn.hutool.core.bean.BeanUtil;
//import com.fasterxml.jackson.annotation.JsonPropertyOrder;
//import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
//import com.paytend.amex.tx.dto.XmlRequest;
//import com.paytend.amex.utils.XmlUtility;
import lombok.Getter;
import lombok.Setter;

/**
 * @author XX
 * 
 */
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
@Setter
@Getter
public class ReversalRequestDto extends BaseFields
//        implements XmlRequest
{

    /**
     * Description:
     * Note: This requirement applies to the container element and all related sub-elements.
     * This container element holds the sub-elements listed in the following example;
     * and the sub-elements must contain the same values used in the original Authorization Request (1100) message.
     */
    OriginalDataElementsDto OriginalDataElementsDto;
//
//    @Override
//    protected String toXml() {
//        String xml = XmlUtility.getInstance().getString(this);
//        return "AuthorizationRequestParam=<?xml version=\"1.0\" encoding=\"utf-8\"?>" + XmlUtility.getInstance().formatXml(xml);
//    }

//    protected ReversalRequest(OriginalDataElements originalDataElements, Authorization authorization) {
////        BeanUtil.copyProperties(authorization, this);
//        this.OriginalDataElements = originalDataElements;
//    }
}
