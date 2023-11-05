package com.paytend.amex.api;


import com.paytend.amex.CommonRsp;
import com.paytend.amex.tx.dto.TxHeader;
import com.paytend.amex.tx.dto.req.AuthorizationDto;
import com.paytend.amex.tx.dto.req.BatchAdminRequestDto;
import com.paytend.amex.tx.dto.req.DataCaptureRequestDto;
import com.paytend.amex.tx.dto.rsp.AuthorizationRspDto;
import com.paytend.amex.tx.AmexAuthCommandService;
import com.paytend.amex.tx.dto.rsp.BatchRespDto;
import com.paytend.amex.tx.dto.rsp.DataCaptureRspDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Optional;

/**
 * @author XX
 */

@RestController
@RequestMapping(value = "tx", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@Tag(name = "交易结算类接口")


public class TxController {

    @Resource
    private AmexAuthCommandService amexAuthCommandService;


    @Operation(summary = "NCP授权接口", description = "做NCP授权")
    @Parameter(name = "region", in = ParameterIn.HEADER, description = "地区欧洲地区固定写 EMEA 参考考HTTPSCommGuide_FINAL.pdf", required = true)
    @Parameter(name = "country", in = ParameterIn.HEADER, description = "ISO标准国家3位数字的国家代码HTTPSCommGuide_FINAL.pdf", required = true)
    @Parameter(name = "merchnbr", in = ParameterIn.HEADER, description = "商户号(Merchant ID)/服务商号（SE-service establishment number） ", required = true)
    @Parameter(name = "origin", in = ParameterIn.HEADER, description = "开发系统实体名称可固定paytend", required = true)
    @Parameter(name = "message", in = ParameterIn.HEADER, description = "消息类型同一类型固定(GFSG XML BAR/GFSG XML DCR/XML GCAG 参考考HTTPSCommGuide_FINAL.pdf)", required = true)
    @Parameter(name = "rtind", in = ParameterIn.HEADER, description = "路由上游分配交同类交易固定", required = true)

    @PostMapping(path = "auth", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonRsp<AuthorizationRspDto> auth(@RequestBody AuthorizationDto authorization,
                                               @RequestHeader Map<String, String> headers) {
        log.info("auth>>>>>{} {}", authorization, headers);
        authorization.setEcommerceAuthorizationValue();
        log.info("MsgTypId:" + authorization.getMsgTypId());
        AuthorizationRspDto rsp = amexAuthCommandService.auth(authorization, buildHeader(headers));
        log.info("auth rsp>>>>>  {}", rsp);
        return CommonRsp.OK(rsp);
    }

    @Operation(summary = "批次管理接口", description = "开批次接口")
    @Parameter(name = "region", in = ParameterIn.HEADER, description = "地区欧洲地区固定写 EMEA 参考考HTTPSCommGuide_FINAL.pdf", required = true)
    @Parameter(name = "country", in = ParameterIn.HEADER, description = "ISO标准国家3位数字的国家代码HTTPSCommGuide_FINAL.pdf", required = true)
    @Parameter(name = "merchnbr", in = ParameterIn.HEADER, description = "商户号(Merchant ID)/服务商号（SE-service establishment number） ", required = true)
    @Parameter(name = "origin", in = ParameterIn.HEADER, description = "开发系统实体名称可固定paytend", required = true)
    @Parameter(name = "message", in = ParameterIn.HEADER, description = "消息类型同一类型固定(GFSG XML BAR/GFSG XML DCR/XML GCAG 参考考HTTPSCommGuide_FINAL.pdf)", required = true)
    @Parameter(name = "rtind", in = ParameterIn.HEADER, description = "路由上游分配交同类交易固定", required = true)


    @PostMapping(path = "batchAdmin", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonRsp<BatchRespDto> batchAdmin(@RequestBody BatchAdminRequestDto batchAdminRequestDto,
                                              @RequestHeader Map<String, String> headers) {
        log.info("auth>>>>>{} {}", batchAdminRequestDto, headers);
        BatchRespDto rsp = amexAuthCommandService.batchAdmin(batchAdminRequestDto, buildHeader(headers));
        log.info("auth rsp>>>>>  {}", rsp);
        return CommonRsp.OK(rsp);
    }


    @Operation(summary = "结算接口", description = "结算接口")
    @Parameter(name = "region", in = ParameterIn.HEADER, description = "地区欧洲地区固定写 EMEA 参考考HTTPSCommGuide_FINAL.pdf", required = true)
    @Parameter(name = "country", in = ParameterIn.HEADER, description = "ISO标准国家3位数字的国家代码HTTPSCommGuide_FINAL.pdf", required = true)
    @Parameter(name = "merchnbr", in = ParameterIn.HEADER, description = "商户号(Merchant ID)/服务商号（SE-service establishment number） ", required = true)
    @Parameter(name = "origin", in = ParameterIn.HEADER, description = "开发系统实体名称可固定paytend", required = true)
    @Parameter(name = "message", in = ParameterIn.HEADER, description = "消息类型同一类型固定(GFSG XML BAR/GFSG XML DCR/XML GCAG 参考考HTTPSCommGuide_FINAL.pdf)", required = true)
    @Parameter(name = "rtind", in = ParameterIn.HEADER, description = "路由上游分配交同类交易固定", required = true)

    @PostMapping(path = "dataCapture", produces = MediaType.APPLICATION_JSON_VALUE)

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "成功",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CommonRsp.class))}),
    })
    @io.swagger.v3.oas.annotations.parameters.RequestBody(content =
            {@Content(schema = @Schema(implementation = DataCaptureRequestDto.class)
            )})

    @ApiResponse(content =
            {@Content(schema = @Schema(implementation = CommonRsp.class))})
    public CommonRsp<DataCaptureRspDto> dataCapture(@RequestBody DataCaptureRequestDto dataCaptureRequest,
                                                    @RequestHeader Map<String, String> headers) {
        log.info("auth>>>>>{} {}", dataCaptureRequest, headers);
        DataCaptureRspDto rsp = amexAuthCommandService.dataCapture(dataCaptureRequest, buildHeader(headers));
        log.info("auth rsp>>>>>  {}", rsp);
        return CommonRsp.OK(rsp);
    }


    private TxHeader buildHeader(Map<String, String> headers) {
        return TxHeader.builder()
                .origin(Optional.of(headers.get("origin")).get())
                .country(Optional.of(headers.get("country")).get())
                .merchNbr(Optional.of(headers.get("merchnbr")).get())
                .region(Optional.of(headers.get("region")).get())
                .message(Optional.of(headers.get("message")).get())
                //http 获取头都是小写
                .rtInd(Optional.of(headers.get("rtind")).get())
                .build();
    }

    public TxController(AmexAuthCommandService amexAuthCommandService) {
        this.amexAuthCommandService = amexAuthCommandService;
    }
}
