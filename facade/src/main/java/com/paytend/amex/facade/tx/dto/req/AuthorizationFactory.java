package com.paytend.amex.facade.tx.dto.req;

 import lombok.Builder;

 import java.util.Objects;

/**
 * @author gudongyang
 */
public class AuthorizationFactory {

    private AuthorizationConfig config;

    public AuthorizationFactory(AuthorizationConfig config) {
        this.config = config;
    }

    @Builder
    public static class AuthorizationConfig {
        Authorization.AuthorizationBuilder authorizationBuilder;
        PointOfServiceData.PointOfServiceDataBuilder pointOfServiceDataBuilder;
        //can null
        SecureAuthenticationSafeKey.SecureAuthenticationSafeKeyBuilder secureAuthenticationSafeKeyBuilder;
        CardAcceptorIdentification.CardAcceptorIdentificationBuilder cardAcceptorIdentificationBuilder;
        CardAcceptorDetail.CardAcceptorDetailBuilder cardAcceptorDetailBuilder;
        CardNotPresentData.CardNotPresentDataBuilder cardNotPresentDataBuilder;
        AcptEnvData.AcptEnvDataBuilder acptEnvDataBuilder;
        NatlUseData.NatlUseDataBuilder natlUseDataBuilder;
    }


    public Authorization create() {
        Authorization.AuthorizationBuilder authorizationBuilder = config.authorizationBuilder;
        if (Objects.nonNull(config.cardAcceptorDetailBuilder)) {
            authorizationBuilder.cardAcceptorIdentification(config.cardAcceptorIdentificationBuilder.build());
        }
        if (Objects.nonNull(config.cardAcceptorDetailBuilder)) {
            authorizationBuilder.cardAcceptorDetail(config.cardAcceptorDetailBuilder.build());

        }
        if (Objects.nonNull(config.cardNotPresentDataBuilder)) {
            AdditionalDataNational additionalDataNational = AdditionalDataNational.builder()
                    .cardNotPresentData(config.cardNotPresentDataBuilder.build())
                    .build();
            authorizationBuilder.additionalDataNational(additionalDataNational);
        }
        if (Objects.nonNull(config.pointOfServiceDataBuilder)) {
            authorizationBuilder.pointOfServiceData(config.pointOfServiceDataBuilder.build());
        }
        if (Objects.nonNull(config.acptEnvDataBuilder)) {
            authorizationBuilder.acptEnvData(config.acptEnvDataBuilder.build());
        }

        if (config.secureAuthenticationSafeKeyBuilder != null) {
            authorizationBuilder.secureAuthenticationSafeKey(config.secureAuthenticationSafeKeyBuilder.build());
        }

        if (config.natlUseDataBuilder != null) {
            authorizationBuilder.natlUseData(config.natlUseDataBuilder.build());
        }

        return authorizationBuilder.build();
    }

}
