package com.paytend.amex.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * {
 * "acsTransID": "741b34fc-f6bf-4939-9916-6326274dcefc",
 * "challengeCompletionInd": "Y",
 * "messageType": "CRes",
 * "messageVersion": "2.2.0",
 * "threeDSServerTransID": "e14ce811-d2db-4650-9f5f-86655ac0a281",
 * "transStatus": "Y"
 * }
 * {"acsTransID":"bd881099-176b-4e23-8c28-c9d5e533ee91","challengeCompletionInd":"Y","messageType":"CRes","messageVersion":"2.2.0","threeDSServerTransID":"809394d7-df08-404b-a636-dc3bc70e2c73","transStatus":"Y"}
 *
 * @author XX
 */

@Data
public class AuthNotifyVo {
    @JsonProperty("acsTransID")
    private String acsTransId;
    private String challengeCompletionInd;
    @JsonProperty("threeDSServerTransID")
    private String threeDsServerTransId;
    private String messageType;
    private String messageVersion;
    private String transStatus;
}
