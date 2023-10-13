package com.paytend.amex.api;

import cn.hutool.json.JSONUtil;
import com.paytend.amex.facade.ds.dto.SupportedVersionReqDto;
import com.paytend.amex.facade.ds.dto.SupportedVersionRspDto;
import com.paytend.amex.facade.tx.dto.CommonRsp;
import com.paytend.amex.facade.tx.dto.req.Authorization;
import com.paytend.amex.service.DsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

    @PostMapping(path = "supportedVersion")
    public CommonRsp<SupportedVersionRspDto> supportedVersion(@RequestBody SupportedVersionReqDto versionReqDto) {
        log.info("req:{}", versionReqDto);
        SupportedVersionRspDto rsp = dsService.supportedVersion(versionReqDto);
        log.info("rsp:{}", JSONUtil.toJsonStr(CommonRsp.OK(rsp)));
        return CommonRsp.OK(rsp);
    }

    public DsController(DsService dsService) {
        this.dsService = dsService;
    }

}
