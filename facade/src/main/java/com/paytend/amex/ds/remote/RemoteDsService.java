package com.paytend.amex.ds.remote;


import com.paytend.amex.ds.dto.AutherizationDsReqDto;
import com.paytend.amex.ds.dto.AutherizationDsRspDto;
import com.paytend.amex.ds.dto.SupportedVersionReqDto;
import com.paytend.amex.ds.dto.SupportedVersionRspDto;

/**
 * @author XX
 */
public interface RemoteDsService {
    SupportedVersionRspDto doSupportedVersion(SupportedVersionReqDto req);

    AutherizationDsRspDto doAuthentication(AutherizationDsReqDto auth, String threeDsServerTransId);
}
