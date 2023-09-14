package com.paytend.amex.api;


import com.paytend.amex.facade.tx.dto.CommonRsp;
import com.paytend.amex.facade.tx.dto.TxHeader;
import com.paytend.amex.facade.tx.dto.req.Authorization;
import com.paytend.amex.facade.tx.dto.rsp.AuthorizationRsp;
import com.paytend.amex.service.SafeKeyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Optional;

/**
 * @author Sunny
 * @create 2023/9/12 08:52
 */

@RestController
@RequestMapping(value = "tx")
@Slf4j
public class TxController {

    @Resource
    private SafeKeyService safeKeyService;

    @PostMapping(path = "auth")
    public CommonRsp<AuthorizationRsp> auth(@RequestBody Authorization authorization,
                                            @RequestHeader Map<String, String> headers) {
        log.info("auth>>>>>{} {}", authorization, headers);
        AuthorizationRsp rsp = safeKeyService.auth(authorization, buildHeader(headers));
        log.info("auth rsp>>>>>  {}", rsp);
        CommonRsp<AuthorizationRsp> ret = new CommonRsp<>();
        ret.setData(rsp);
        return ret;
    }

    private TxHeader buildHeader(Map<String, String> headers) {
        return TxHeader.builder()
                .origin(Optional.of(headers.get("origin")).get())
                .country(Optional.of(headers.get("country")).get())
                .merchNbr(Optional.of(headers.get("merchnbr")).get())
                .region(Optional.of(headers.get("region")).get())
                .build();
    }

    public TxController() {
    }

    public TxController(SafeKeyService safeKeyService) {
        this.safeKeyService = safeKeyService;
    }
}
