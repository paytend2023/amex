package com.paytend.amex.ds;

import com.paytend.amex.facade.ds.dto.AutherizationDsReqDto;
import com.paytend.amex.facade.ds.dto.AutherizationDsRspDto;
import com.paytend.amex.facade.ds.dto.SupportedVersionReqDto;
import com.paytend.amex.facade.ds.dto.SupportedVersionRspDto;
import com.paytend.amex.ds.remote.RemoteDsService;

import org.springframework.stereotype.Service;

/**
 * @author XX
 * 
 */
@Service
public class DsCommandService {
    final RemoteDsService remoteDsService;

    public DsCommandService(RemoteDsService remoteDsService) {
        this.remoteDsService = remoteDsService;
    }

    public SupportedVersionRspDto supportedVersion(SupportedVersionReqDto versionReqDto) {
        return remoteDsService.doSupportedVersion(versionReqDto);
    }

    public AutherizationDsRspDto doAuthentication(AutherizationDsReqDto auth, String threeDsServerTransId) {
        return remoteDsService.doAuthentication(auth, threeDsServerTransId);
    }
}
