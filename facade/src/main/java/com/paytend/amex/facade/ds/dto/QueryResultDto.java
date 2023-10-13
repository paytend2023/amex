package com.paytend.amex.facade.ds.dto;

import lombok.Data;

import java.util.Map;

/**
 * @author Sunny
 * @create 2023/9/18 17:08
 */
@Data
public class QueryResultDto {

//    "threeDSServerTransID":"8a880dc0-d2d2-4067-bcb1-b08d1690b26f",
//            "errorCode":"203",
//            "errorComponent":"S",
//            "errorDescription":"Format of one or more Data Elements is Invalid according to the Specification",
//            "errorDetail":"3DS Server",
//            "errorMessageType":"Erro",
//            "messageVersion":"2.1.0"


//    "threeDSServerTransID": "f65126e4-f61c-43fe-bb24-2dbeb8caaba6",
//            "acsTransID": "7382aac4-2fbe-40ea-8959-f0025e266e80",
//            "authenticationType": "02",
//            "authenticationValue": "kBNS2K+b0zjbAQPomm3SKBVhXwxO",
//            "dsTransID": "21aa1a50-0d0a-41b0-b92a-ee918ffd0b6c",
//            "eci": "02",
//            "interactionCounter": "02",
//            "messageCategory": "01",
//            "messageType": "RReq",
//            "messageVersion": "2.1.0",
//            "transStatus": "Y"


//  "code": 200,
//  "message": "success",

    private String code;
    private String message;


    //错误返回
    private String threeDSServerTransID;
    private String errorCode;
    private String errorComponent;
    private String errorDescription;
    private String errorDetail;
    private String messageVersion;


    Map<String, String> data;
}
