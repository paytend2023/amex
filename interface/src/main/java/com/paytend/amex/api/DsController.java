package com.paytend.amex.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paytend.amex.api.model.AuthNotifyVo;
import com.paytend.amex.facade.ds.dto.AutherizationDsReqDto;
import com.paytend.amex.facade.ds.dto.AutherizationDsRspDto;
import com.paytend.amex.facade.tx.dto.CommonRsp;
import com.paytend.amex.biz.DsCommandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import java.util.Base64;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author XX
 * 
 */
@RestController
@RequestMapping(value = "ds")
@Slf4j
public class DsController {
    @Resource
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private ObjectMapper jasonObjMapper;
    @Resource
    public DsCommandService dsCommandService;



    @PostMapping(path = "doAuthentication", produces = APPLICATION_JSON_VALUE)
    public CommonRsp<AutherizationDsRspDto> doAuthentication(@RequestBody AutherizationDsReqDto auth,
                                                             @RequestHeader("threeDsServerTransId") String threeDsServerTransId) {
        auth.setNotificationURL(auth.getAcctNumber());
        AutherizationDsRspDto dto = dsCommandService.doAuthentication(auth, threeDsServerTransId);
        return CommonRsp.OK(dto);
    }

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

    public DsController(DsCommandService dsCommandService) {
        this.dsCommandService = dsCommandService;
    }
}
