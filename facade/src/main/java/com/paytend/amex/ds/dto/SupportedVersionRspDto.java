package com.paytend.amex.ds.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author XX
 */
@Data
@Schema(description = "supportedVersion 返回结构体")
public class SupportedVersionRspDto extends BaseErrRspData {
    //    {
//        "threeDSMethodURL": "https://dig3ds.cafis-paynet.jp:443/99660/",
//            "endProtocolVersion": "2.2.0",
//            "startProtocolVersion": "2.1.0",
//            "threeDSServerTransID": "78828e38-f006-4397-9915-b4e36d9b9ed3",
//            "dateTime": "2022-09-13 15:27:17",
//            "threedsmethodHtml": "<form id=\"frm\" name=\"frm\" method=\"POST\" action=\"https://dig3ds.cafis-paynet.jp:443/99660/\"><input type=\"hidden\" name=\"threeDSMethodData\" value=\"eyJ0aHJlZURTU2VydmVyVHJhbnNJRCI6Ijc4ODI4ZTM4LWYwMDYtNDM5Ny05OTE1LWI0ZTM2ZDliOWVkMyIsInRocmVlRFNNZXRob2ROb3RpZmljYXRpb25VUkwiOiJodHRwczovL3d3dy5iYWlkdS5jb20ifQ==\"> </form>"
//    }
    @Schema(description = "3DS方法将使用的ACSURL")
    private String threeDSMethodURL;
    @Schema(description = "支持3DS认证最新的协议版本")
    private String endProtocolVersion;
    @Schema(description = "3ds事务id")

    private String threeDSServerTransID;
    @Schema(description = "当前时间")
    private String dateTime;
    @Schema(description = "3ds method页面")
    private String threedsmethodHtml;
}
