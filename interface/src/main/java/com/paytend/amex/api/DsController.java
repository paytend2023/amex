package com.paytend.amex.api;

import cn.hutool.json.JSONUtil;
import com.paytend.amex.facade.ds.dto.AutherizationDsReqDto;
import com.paytend.amex.facade.ds.dto.AutherizationDsRspDto;
import com.paytend.amex.facade.ds.dto.SupportedVersionReqDto;
import com.paytend.amex.facade.ds.dto.SupportedVersionRspDto;
import com.paytend.amex.facade.tx.dto.CommonRsp;
import com.paytend.amex.service.DsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author Sunny
 * @create 2023/9/15 13:07
 */
@RestController
@RequestMapping(value = "ds")
@Slf4j
public class DsController {

    @Resource
    public DsService dsService;

    private static final String NOTIFY_URL = "http://180.168.215.67:9088/3ds/view/supportedVersionNotify/";
//    private static final String NOTIFY_URL = "https://2b145863i9.yicp.fun/view/supportedVersionNotify/";

    @PostMapping(path = "supportedVersion", produces = APPLICATION_JSON_VALUE)
    public CommonRsp<SupportedVersionRspDto> supportedVersion(@RequestBody SupportedVersionReqDto versionReqDto) {
        log.info("req:{}", versionReqDto);
        versionReqDto.setNotificationURL(NOTIFY_URL + versionReqDto.getCardNo());
        SupportedVersionRspDto rsp = dsService.supportedVersion(versionReqDto);
        log.info("rsp:{}", JSONUtil.toJsonStr(CommonRsp.OK(rsp)));
        return CommonRsp.OK(rsp);
    }
    @PostMapping(path = "doAuthentication", produces = APPLICATION_JSON_VALUE)
    public CommonRsp<AutherizationDsRspDto> doAuthentication(@RequestBody AutherizationDsReqDto auth,
                                                             @RequestHeader("threeDsServerTransId") String threeDsServerTransId) {
        AutherizationDsRspDto dto = dsService.doAuthentication(auth, threeDsServerTransId);
        return CommonRsp.OK(dto);
    }

    public DsController(DsService dsService) {
        this.dsService = dsService;
    }
}
