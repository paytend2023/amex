package com.paytend.amex.service;

import com.paytend.amex.facade.ds.RemoteDsService;
import com.paytend.amex.facade.ds.dto.AutherizationDsReqDto;
import com.paytend.amex.facade.ds.dto.AutherizationDsRspDto;
import com.paytend.amex.facade.ds.dto.SupportedVersionReqDto;
import com.paytend.amex.facade.ds.dto.SupportedVersionRspDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Sunny
 * @create 2023/9/15 13:08
 */
@Service
public class DsService {
    final RemoteDsService remoteDsService;

    public DsService(RemoteDsService remoteDsService) {
        this.remoteDsService = remoteDsService;
    }

    public SupportedVersionRspDto supportedVersion(SupportedVersionReqDto versionReqDto) {
        return remoteDsService.doSupportedVersion(versionReqDto);
    }

    public AutherizationDsRspDto doAuthentication(AutherizationDsReqDto auth, String threeDsServerTransId) {
        return remoteDsService.doAuthentication(auth, threeDsServerTransId);
    }
}
