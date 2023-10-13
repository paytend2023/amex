package com.paytend.amex.tx.remote;

import com.paytend.amex.tx.dto.TxHeader;
import com.paytend.amex.tx.dto.req.Authorization;
import com.paytend.amex.tx.dto.rsp.AuthorizationRsp;

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
