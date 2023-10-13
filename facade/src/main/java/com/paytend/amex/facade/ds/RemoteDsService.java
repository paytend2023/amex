package com.paytend.amex.facade.ds;

import com.paytend.amex.facade.ds.dto.AutherizationDsReqDto;
import com.paytend.amex.facade.ds.dto.AutherizationDsRspDto;
import com.paytend.amex.facade.ds.dto.SupportedVersionReqDto;
import com.paytend.amex.facade.ds.dto.SupportedVersionRspDto;

/**
 * @author Sunny
 * @create 2023/9/15 12:52
 */
public interface RemoteDsService {
    public SupportedVersionRspDto doSupportedVersion(SupportedVersionReqDto req);

    public AutherizationDsRspDto doAuthentication(AutherizationDsReqDto auth, String threeDsServerTransId);
}
