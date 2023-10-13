package com.paytend.amex.facade.ds.dto;

import lombok.Data;
import lombok.ToString;

/**
 * @author Sunny
 * @create 2023/9/18 20:05
 */
@Data
@ToString
public class QueryRespDto {
    private String code;
    private String message;

    private QueryRspData data;

    /**
     * {"threeDSServerTransID":"0e304a1a-805e-4db9-9ced-94bdf62221de","acsChallengeMandated":"N","acsReferenceNumber":"3DS_LOA_ACS_UPIT_000000_00001","acsTransID":"b8e2b34a-105a-4db0-b38e-91c13001cd3c","dsTransID":"dc220958-4240-452f-9026-7bbe57d5b7b9","dsReferenceNumber":"3DS_LOA_DIS_CUCC_020100_00103","eci":"07","messageVersion":"2.2.0","transStatus":"U","messageType":"pArs","transStatusReason":"01"}
     */
    @Data
    @ToString
    public static class QueryRspData {
        private String threeDSServerTransID;
        private String acsChallengeMandated;
        private String acsReferenceNumber;
        private String acsTransID;
        private String dsTransID;
        private String dsReferenceNumber;
        private String eci;
        private String messageVersion;
        private String transStatus;
        private String messageType;
        private String transStatusReason;
    }
}
