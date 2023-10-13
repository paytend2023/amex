package com.paytend.amex.facade.tx.dto.req;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.experimental.Tolerate;

/**
 * @author XX
 * 
 */
@Getter
@Setter
@SuperBuilder
@ToString
public class BaseFields {

    /**
     * bit 0
     */
    protected String msgTypId;
    /**
     * bit 2
     */
    protected String cardNbr;
    /**
     * bit 3
     */
    protected String transProcCd;
    /**
     * bit 4
     */
    protected String transAmt;
    /**
     * bit 7
     */

    protected String xmitTs;
    /**
     * bit 11
     */
    protected String merSysTraceAudNbr;
    /**
     * YYMMDDhhmmss
     * bit 12
     */
    protected String transTs;
    /**
     * YYMM.
     * bit 13
     */
    protected String cardEffDt;
    /**
     * YYMM
     * bit 14
     */
    protected String cardExprDt;
    /**
     * bit 19
     */
    protected String acqInstCtryCd;
    /**
     * bit 22
     */
    protected PointOfServiceData pointOfServiceData;


    /**
     * bit 24
     */
    protected String funcCd;

    /**
     * bit 25
     */
    protected String msgRsnCd;

    /**
     * bit 26
     */
    protected String merCtgyCd;
    /**
     * bit 27
     */
    protected String aprvCdLgth;
    /**
     * bit 31
     */
    protected String transId;
    /**
     * bit 32
     */
    protected String acqInstIdCd;
    /**
     * bit 33
     */
    protected String fwdInstIdCd;
    /**
     * bit 35
     */
    protected String cardTrack2Data;
    /**
     * bit 37
     */
    protected String rtrvRefNbr;
    /**
     * bit 41
     */
    protected String merTrmnlId;
    /**
     * bit 42
     */
    protected CardAcceptorIdentification cardAcceptorIdentification;
    /**
     * bit 43
     */
    protected CardAcceptorDetail cardAcceptorDetail;
    /**
     * bit 45
     */
    protected String cardTrack1Data;
    /**
     * bit 47
     */
    protected AdditionalDataNational additionalDataNational;
    /**
     * bit 48
     */
    protected AdditionalDataPrivate additionalDataPrivate;
    /**
     * bit 49
     */
    protected String transCurrCd;
    /**
     * bit 52
     */
    protected String PINDataTxt;
    /**
     * bit 55
     */
    protected String ICCSDataTxt;
    /**
     * bit 60
     */
    protected NatlUseData natlUseData;
    /**
     * bit 61
     */
    protected SecureAuthenticationSafeKey secureAuthenticationSafeKey;
    /**
     * bit 96
     */
    protected KeyMgmtData keyMgmtData;
    /**
     * bit 111
     */
    protected ExtendedKeyMngtData extendedKeyMngtData;
    /**
     * bit 112
     */
    protected PaymentAcctData paymentAcctData;
    /**
     * bit 113
     */
    protected AcptEnvData acptEnvData;


    @Tolerate
    protected BaseFields() {
    }
}
