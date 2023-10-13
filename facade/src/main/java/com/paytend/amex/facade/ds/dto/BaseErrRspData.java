package com.paytend.amex.facade.ds.dto;

import lombok.Data;

/**
 * @author XX
 * 
 */
@Data
/**
 * {
 *     "errorCode": "205",
 *     "errorComponent": "S",
 *     "errorDescription": "No such card",
 *     "errorDetail": "3DS Server",
 *     "errorMessageType": "PRes",
 *     "messageType": "Erro",
 *     "messageVersion": "2.2.0"
 * }
 */
public  class BaseErrRspData {


    String errorCode;
    String errorComponent;
    String errorDescription;
    String errorDetail;
    String errorMessageType;
    String messageType;
    String messageVersion;

}
