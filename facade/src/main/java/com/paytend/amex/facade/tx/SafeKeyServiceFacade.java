package com.paytend.amex.facade.tx;

import com.paytend.amex.facade.tx.dto.TxHeader;
import com.paytend.amex.facade.tx.dto.rsp.AuthorizationRsp;
import com.paytend.amex.facade.tx.dto.req.Authorization;
import com.paytend.amex.facade.tx.dto.CommonRsp;

/**
 * @author Sunny
 * @create 2023/9/11 15:58
 */
public interface SafeKeyServiceFacade {

    /**
     * 返回授权信息
     * @param authorization 请求
     * @return 返回
     */
    CommonRsp<AuthorizationRsp> auth(Authorization authorization, TxHeader header);

}
