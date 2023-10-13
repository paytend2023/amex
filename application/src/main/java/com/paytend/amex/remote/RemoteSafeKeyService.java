package com.paytend.amex.remote;

import com.paytend.amex.facade.tx.dto.TxHeader;
import com.paytend.amex.facade.tx.dto.req.Authorization;
import com.paytend.amex.facade.tx.dto.rsp.AuthorizationRsp;

/**
 * @author XX
 * 
 */
public interface RemoteSafeKeyService {
    /**
     * @param authorization  授权交易
     * @param header
     * @return
     * @throws Exception
     */
    AuthorizationRsp auth(Authorization authorization, TxHeader header) throws Exception  ;
}
