package com.paytend.amex.tx.dto.req;

//import cn.hutool.core.date.DateUtil;
import lombok.Builder;

import java.util.Objects;

/**
 * @author  XIXI
 */
public class AuthorizationFactory {

    private AuthorizationConfig config;

    public AuthorizationFactory(AuthorizationConfig config) {
        this.config = config;
    }

    @Builder
    public static class AuthorizationConfig {
        AuthorizationDto.AuthorizationDtoBuilder authorizationBuilder;
        PointOfServiceDataDto.PointOfServiceDataDtoBuilder pointOfServiceDataBuilder;
        //can null
        SecureAuthenticationSafeKeyDto.SecureAuthenticationSafeKeyDtoBuilder secureAuthenticationSafeKeyBuilder;
        CardAcceptorIdentificationDto.CardAcceptorIdentificationDtoBuilder cardAcceptorIdentificationBuilder;
        CardAcceptorDetailDto.CardAcceptorDetailDtoBuilder cardAcceptorDetailBuilder;
        CardNotPresentDataDto.CardNotPresentDataDtoBuilder cardNotPresentDataBuilder;
        AcptEnvDataDto.AcptEnvDataDtoBuilder acptEnvDataBuilder;
        NatlUseDataDto.NatlUseDataDtoBuilder natlUseDataBuilder;
    }


    public AuthorizationDto create() {
        AuthorizationDto.AuthorizationDtoBuilder authorizationBuilder = config.authorizationBuilder;
        if (Objects.nonNull(config.cardAcceptorDetailBuilder)) {
            authorizationBuilder.CardAcceptorIdentification(config.cardAcceptorIdentificationBuilder.build());
        }
        if (Objects.nonNull(config.cardAcceptorDetailBuilder)) {
            authorizationBuilder.CardAcceptorDetail(config.cardAcceptorDetailBuilder.build());

        }
        if (Objects.nonNull(config.cardNotPresentDataBuilder)) {
            AdditionalDataNationalDto additionalDataNational = AdditionalDataNationalDto.builder()
                    .CardNotPresentData(config.cardNotPresentDataBuilder.build())
                    .build();
            authorizationBuilder.AdditionalDataNational(additionalDataNational);
        }
        if (Objects.nonNull(config.pointOfServiceDataBuilder)) {
            authorizationBuilder.PointOfServiceData(config.pointOfServiceDataBuilder.build());
        }
        if (Objects.nonNull(config.acptEnvDataBuilder)) {
            authorizationBuilder.AcptEnvData(config.acptEnvDataBuilder.build());
        }

        if (config.secureAuthenticationSafeKeyBuilder != null) {
            authorizationBuilder.SecureAuthenticationSafeKey(config.secureAuthenticationSafeKeyBuilder.build());
        }

        if (config.natlUseDataBuilder != null) {
            authorizationBuilder.NatlUseData(config.natlUseDataBuilder.build());
        }

//        buildTransTs(authorizationBuilder);
        return authorizationBuilder.build();
    }

//    private void buildTransTs(Authorization.AuthorizationBuilder authorizationBuilder) {
//        //YYMMDDhhmmss
//        authorizationBuilder.TransTs(DateUtil.format(new Date(), "yyyyMMddHHmmss").substring(2));
//    }

}
