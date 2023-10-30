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
@RequestMapping(value = "tx" ,produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class TxController {

    @Resource
    private AmexAuthCommandService amexAuthCommandService;



    @PostMapping(path = "auth")
    public CommonRsp<AuthorizationRspDto> auth(@RequestBody AuthorizationDto authorization,
                                               @RequestHeader Map<String, String> headers) {
        log.info("auth>>>>>{} {}", authorization, headers);
        authorization.setEcommerceAuthorizationValue();
        log.info("MsgTypId:" + authorization.getMsgTypId());
        AuthorizationRspDto rsp = amexAuthCommandService.auth(authorization, buildHeader(headers));
        log.info("auth rsp>>>>>  {}", rsp);
        return CommonRsp.OK(rsp);
    }

    @PostMapping(path = "batchAdmin")
    public CommonRsp<BatchRespDto> batchAdmin(@RequestBody BatchAdminRequestDto batchAdminRequestDto,
                                         @RequestHeader Map<String, String> headers) {
        log.info("auth>>>>>{} {}", batchAdminRequestDto, headers);
        BatchRespDto rsp = amexAuthCommandService.batchAdmin(batchAdminRequestDto, buildHeader(headers));
        log.info("auth rsp>>>>>  {}", rsp);
        return CommonRsp.OK(rsp);
    }
    @PostMapping(path = "dataCapture")
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

    public TxController() {
    }

    public TxController(AmexAuthCommandService amexAuthCommandService) {
        this.amexAuthCommandService = amexAuthCommandService;
    }
}
