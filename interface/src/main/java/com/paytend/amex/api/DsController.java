package com.paytend.amex.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paytend.amex.api.vo.AuthNotifyVo;

import com.paytend.amex.ds.dto.AutherizationDsReqDto;
import com.paytend.amex.ds.dto.AutherizationDsRspDto;
import com.paytend.amex.CommonRsp;
import com.paytend.amex.ds.DsCommandService;
import com.paytend.amex.ds.dto.SupportedVersionReqDto;
import com.paytend.amex.ds.dto.SupportedVersionRspDto;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import java.util.Base64;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author XX
 */
@RestController
@RequestMapping(value = "ds")
@Slf4j
@Tags({
        @Tag(name = "supportedVersion", description = "supportedVersion接口", externalDocs = @ExternalDocumentation(url = "https://doc.next-api.com/web/#/15/234")),
        @Tag(name = "doAuthentication", description = "authentication 接口 ", externalDocs = @ExternalDocumentation(url = "https://doc.next-api.com/web/#/15/234"))
}
)
public class DsController {
    @Resource
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private ObjectMapper jasonObjMapper;
    @Resource
    public DsCommandService dsCommandService;


    /**
     * 本地测试使用
     *
     * @param auth
     * @param threeDsServerTransId
     * @return
     */

    @PostMapping(path = "doAuthenticationT", produces = APPLICATION_JSON_VALUE)
    @Hidden
    public CommonRsp<AutherizationDsRspDto> doAuthenticationT(@RequestBody AutherizationDsReqDto auth,
                                                              @RequestHeader("threeDsServerTransId") String threeDsServerTransId) {
        auth.setNotificationURL(auth.getAcctNumber());
        AutherizationDsRspDto dto = dsCommandService.doAuthentication(auth, threeDsServerTransId);
        return CommonRsp.OK(dto);
    }

    @Hidden
    @RequestMapping(path = "authNotify/{cardAsn}",
            method = {RequestMethod.GET, RequestMethod.POST},
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public AuthNotifyVo receiveAuthNotify(@PathVariable("cardAsn") String cardAsn,
                                          @RequestHeader HttpHeaders headers,
                                          @RequestParam("cres") String data
    ) throws JsonProcessingException {
        log.info("data: {}", data);
        headers.forEach((k, v) -> log.info("header {}={}", k, v));
        return jasonObjMapper.readValue(new String(Base64.getDecoder().decode(data)), AuthNotifyVo.class);
    }


    @Operation(summary = " 3DS请求者使用持卡人账号和其他持卡人信息请求ACS启动协议版本、ACS结束协议版本、DS开始协议版本和DS结束协议版本，" +
            "如果存在，则该BIN的3DS方法URL来自3DS服务器。")

    @Parameters({
            @Parameter(name = "cardNo", description = "卡号"),
            @Parameter(name = "notificationURL", description = "回调地址,主要用于接收来自ACS表单提交后的信息")
    }


    )
    @RequestMapping(path = "supportedVersion", method = {RequestMethod.GET, RequestMethod.POST})
    @ApiResponse(
            description = "一、若threeDSMethodURL存在，则需要表单提交：\n" +
                    "在表单提交后，若在10s内收到回调，则下一步认证请求中threeDSCompInd=Y,否则threeDSCompInd=N\n" +
                    "\n" +
                    "二、若threeDSMethodURL不存在，则不需要表单提交\n" +
                    "如果threeDSMethodURL不存在，则下一步认证请求中threeDSCompInd=U",
            content = @Content(examples = {
                    @ExampleObject(name = "example", value = "{\n" +
                            "    \"threeDSMethodURL\": \"https://dig3ds.cafis-paynet.jp:443/99660/\",\n" +
                            "    \"endProtocolVersion\": \"2.2.0\",\n" +
                            "    \"startProtocolVersion\": \"2.1.0\",\n" +
                            "    \"threeDSServerTransID\": \"78828e38-f006-4397-9915-b4e36d9b9ed3\",\n" +
                            "    \"dateTime\": \"2023-11-05 15:27:17\",\n" +
                            "    \"threedsmethodHtml\": \"<form id=\\\"frm\\\" name=\\\"frm\\\" method=\\\"POST\\\" action=\\\"https://dig3ds.cafis-paynet.jp:443/99660/\\\"><input type=\\\"hidden\\\" name=\\\"threeDSMethodData\\\" value=\\\"eyJ0aHJlZURTU2VydmVyVHJhbnNJRCI6Ijc4ODI4ZTM4LWYwMDYtNDM5Ny05OTE1LWI0ZTM2ZDliOWVkMyIsInRocmVlRFNNZXRob2ROb3RpZmljYXRpb25VUkwiOiJodHRwczovL3d3dy5iYWlkdS5jb20ifQ==\\\"> </form>\"\n" +
                            "}")
            }))
    public CommonRsp<SupportedVersionRspDto> supportedVersion(@RequestParam("cardNo") String cardAsn,
                                                              @RequestParam("notificationURL") String notificationURL
    ) {
        SupportedVersionReqDto versionReqDto = new SupportedVersionReqDto();
        versionReqDto.setCardNo(cardAsn);
        versionReqDto.setNotificationURL(notificationURL);
        SupportedVersionRspDto rsp = dsCommandService.supportedVersion(versionReqDto);
        CommonRsp<SupportedVersionRspDto> result = CommonRsp.OK(rsp);
        log.info("rsp:{}", result);
        return result;
    }


    /**
     * 包装给第三方使用
     *
     * @param auth
     * @param threeDsServerTransId
     * @return
     */

    @Schema(description = "设备通道\n" +
            "\n" +
            "01-APP：在消费者设备上进行交易期间的认证，该交易源自商家、数字钱包等提供的应用程序。例如，在商家的应用程序中的结账过程中产生的电子商务交易\n" +
            "02-BRW：在消费者设备上进行的交易中，源于利用浏览器的网站。例如，在消费者设备上的网站结账过程中产生的电子商务交易\n" +
            "03-3RI：确认账户信息和持卡人认证，没有直接的持卡人在场，由3DS请求者发起。例如，当3DS请求者和ACS使用解耦认证时，基于订阅的电子商务商户确认账户仍然有效或持卡人认证\n" +
            "消息类别\n" +
            "\n" +
            "01-PA：Payment Authentication（支付认证），电子商务交易中的持卡人认证\n" +
            "02-NPA：Non-Payment Authentication（非支付认证），身份验证和账户确认\n")

    @Parameter(name = "threeDsServerTransId", in = ParameterIn.HEADER, description = "交易ID", required = true)
    @PostMapping(path = "doAuthentication", produces = APPLICATION_JSON_VALUE)
    public CommonRsp<AutherizationDsRspDto> doAuthentication(@RequestBody AutherizationDsReqDto auth,
                                                             @RequestHeader("threeDsServerTransId") String threeDsServerTransId) {
        AutherizationDsRspDto dto = dsCommandService.doAuthentication(auth, threeDsServerTransId);
        return CommonRsp.OK(dto);
    }

    public DsController(DsCommandService dsCommandService) {
        this.dsCommandService = dsCommandService;
    }
}
