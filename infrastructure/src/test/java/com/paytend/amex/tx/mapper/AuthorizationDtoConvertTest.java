package com.paytend.amex.tx.mapper;

import cn.hutool.core.date.DateUtil;
import com.paytend.amex.tx.dto.req.*;
import com.paytend.amex.tx.req.Authorization;
import io.aexp.api.client.core.utils.JsonUtility;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.cglib.beans.BeanCopier;


import java.util.Date;


/**
 * @author Sunny
 */
class AuthorizationDtoConvertTest {

    AuthorizationDto.AuthorizationDtoBuilder
            authorizationBuilder = AuthorizationDto.builder()
            .MsgTypId("1100")
            .TransProcCd("004000")
            .CardExprDt("2501")
            .AcqInstCtryCd("276")
            .FuncCd("100")
            .MsgRsnCd("1900")
            .MerCtgyCd("4111")
            .RtrvRefNbr(DateUtil.format(new Date(), "yyyyMMddHHmmss").substring(2))
            .MerTrmnlId("00000001")
            .TransCurrCd("978").NatlUseData(NatlUseDataDto.builder().OriginalTransId("12121212121212").build())
            ;

    PointOfServiceDataDto.PointOfServiceDataDtoBuilder
            pointOfServiceDataBuilder = PointOfServiceDataDto.builder()
            .CardDataInpCpblCd("1")
            .CMAuthnCpblCd("6")
            .CardCptrCpblCd("0")
            .OprEnvirCd("0")
            .CMPresentCd("1")
            .CardPresentCd("0")
            .CardDataInpModeCd("1")
            .CMAuthnMthdCd("0")
            .CMAuthnEnttyCd("0")
            .CardDataOpCpblCd("0")
            .TrmnlOpCpblCd("1")
            .PINCptrCpblCd("0");

    SecureAuthenticationSafeKeyDto.SecureAuthenticationSafeKeyDtoBuilder
            secureAuthenticationSafeKeyBuilder = SecureAuthenticationSafeKeyDto.builder()
            .ScndIdCd("ASK")
            .ElecComrceInd("05")
            .AmexExpVerificationValTxt("0000010567123487637946538663470000000000");

    CardAcceptorIdentificationDto.CardAcceptorIdentificationDtoBuilder
            cardAcceptorIdentificationBuilder = CardAcceptorIdentificationDto.builder()
            .MerId("8127921740");

    CardAcceptorDetailDto.CardAcceptorDetailDtoBuilder
            cardAcceptorDetailBuilder = CardAcceptorDetailDto.builder()
            .cardAcptNm("PAYTEND EUROPE UAB")
            .cardAcptStreetNm("Vilnius City sav")
            .cardAcptCityNm("Vilnius")
            .cardAcptPostCd("01113")
            .cardAcptRgnCd("58")
            .cardAcptCtryCd("440");

    CardNotPresentDataDto.CardNotPresentDataDtoBuilder
            cardNotPresentDataBuilder = CardNotPresentDataDto.builder()
            .custEmailAddr("king.gu@gmail.com")
            .custHostServerNm("www.baidu.com")
            .custBrowserTypDescTxt("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7)")
            .shipToCtryCd("440")
            .shipMthdCd("01")
            .merSKUNbr("TKDC315U")
            .custIPAddr("127.142.5.56")
            .custIdPhoneNbr("13651654626")
            .callTypId("61");

    AcptEnvDataDto.AcptEnvDataDtoBuilder
            acptEnvDataBuilder = AcptEnvDataDto.builder()
            .InitPartyInd("0")
            .psd2Exemptions(Psd2ExemptionsDto.builder()
                    .EuPsd2SecCorpPayInd("0")
                    .AuthOutageInd("0")
                    .build());


    @Test
    protected void testMapping() {
        AuthorizationFactory.AuthorizationConfig config =
                AuthorizationFactory.AuthorizationConfig.builder()
                        .authorizationBuilder(authorizationBuilder)
                        .pointOfServiceDataBuilder(pointOfServiceDataBuilder)
                        .acptEnvDataBuilder(acptEnvDataBuilder)
                        .build();


        AuthorizationFactory factory = new AuthorizationFactory(config);
        AuthorizationDto authorizationDto = factory.create();
        Authorization authorization = new Authorization();


        BeanCopier.create(AuthorizationDto.class, Authorization.class, false).copy(authorizationDto, authorization, null);

        System.out.println(authorization.toXml());
        System.out.println(JsonUtility.getInstance().getString(authorizationDto));
        System.out.println(JsonUtility.getInstance().getString(authorization));
    }

    @Test
    protected void testMapping1() {
        AuthorizationFactory.AuthorizationConfig config =
                AuthorizationFactory.AuthorizationConfig.builder()
                        .authorizationBuilder(authorizationBuilder)
                        .pointOfServiceDataBuilder(pointOfServiceDataBuilder)
                        .acptEnvDataBuilder(acptEnvDataBuilder)
                        .build();
        AuthorizationFactory factory = new AuthorizationFactory(config);
        AuthorizationDto authorizationDto = factory.create();

        Authorization authorization = new Authorization();
        BeanUtils.copyProperties(authorizationDto, authorization);

        String str = JsonUtility.getInstance().getString(authorizationDto);
        System.out.println(str);

        Object obj =JsonUtility.getInstance().getObject(str, Authorization.class);
        System.out.println(JsonUtility.getInstance().getString(obj)) ;
        System.out.println(JsonUtility.getInstance().getString(authorization));
    }

}