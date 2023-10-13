package com.paytend.amex.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @author XX
 * 
 */
@Data
@ToString
public class NotifyVo {

//     "threeDSServerTransID":"78828e38-f006-4397-9915-b4e36d9b9ed3",
//     "threeDSMethodNotificationURL":"https://www.baidu.com"

    @JsonProperty("threeDSServerTransID")
    private String threeDsServerTransId;

    @JsonProperty("threeDSMethodNotificationURL")
    private String threeDsMethodNotificationUrl;

    @JsonProperty("threeDSMethodURL")
    private String threeDsMethodUrl;

    //非三方回调返回从路径中获取添加
    private String cardAsn;

}
