package com.paytend.amex.tx.dto.req;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

/**
 *
 * 62
 * @author  XIXI
 */
@Getter
@Setter
@Builder
public class ValidationInformation62Dto {

    private AMEXTransponderTransactionDto AMEXTransponderTransaction;
    private VISAPS2000TransactionDto VISAPS2000Transaction;

    @Tolerate
    public ValidationInformation62Dto(){}

}

/*  62域结构
<ValidationInformation>
  <AMEXTransponderTransaction>
    <SecIdCd></SecIdCd>
  </AMEXTransponderTransaction>
  <VISAPS2000Transaction>
    <VISAPS2000QlfyTransInd>
    </VISAPS2000QlfyTransInd>
    <AddVISASubElemValTxt>
    </AddVISASubElemValTxt>
  </VISAPS2000Transaction>
 </ValidationInformation>
 */
/*
 63域结构
<VerificationInformation>
<FormNbr></FormNbr>
 <ServId></ServId>
 <ReqTypId></ReqTypId>
  <MICRNbr></MICRNbr>
  <TCNbr></TCNbr>
 <AddressVerificationData>
    <CMBillPostCd></CMBillPostCd>
    <CMBillAddr></CMBillAddr>
    <CMFirstNm></CMFirstNm>
    <CMLastNm></CMLastNm>
    <CMPhoneNbr></CMPhoneNbr>
    <ShipToPostCd></ShipToPostCd>
    <ShipToAddr></ShipToAddr>
    <ShipToFirstNm></ShipToFirstNm>
    <ShipToLastNm></ShipToLastNm>
    <ShipToPhoneNbr></ShipToPhoneNbr>
    <ShipToCtryCd></ShipToCtryCd>
 </AddressVerificationData>
</VerificationInformation>
 */