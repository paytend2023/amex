package com.paytend.amex.facade.tx.dto.req;

import lombok.Getter;
import lombok.Setter;

/**
 * @author gudongyang
 */
@Getter
@Setter
public class ExtendedKeyMngtData {
    String extDynSesKeyPINData;
    String extPINDataTxt1;
    String dynSesKeyChkVal;
    String extDUKPTPINData;
    String extPINDataTxt2;
    String DUKPTFormat;
    String keySerNbr;
    String KSNKeySetId;
    String KSNDID;
    String KSNTxnCtr;
}

/*
<ExtendedKeyMngtDataReq>
  <ExtDynSesKeyPINData></ExtDynSesKeyPINData>
    <ExtPINDataTxt></ExtPINDataTxt>
    <DynSesKeyChkVal></DynSesKeyChkVal>
    <ExtDUKPTPINData></ExtDUKPTPINData>
    <ExtPINDataTxt></ExtPINDataTxt>
    <DUKPTFormat></DUKPTFormat>
    <KeySerNbr></KeySerNbr>
    <KSNKeySetId></KSNKeySetId>
    <KSNDID></KSNDID>
    <KSNTxnCtr></KSNTxnCtr>
</ExtendedKeyMngtDataReq>
*/
