package com.paytend.amex.remote;

import com.paytend.amex.facade.tx.dto.TxHeader;
import com.paytend.amex.facade.tx.dto.req.Authorization;
import com.paytend.amex.facade.tx.dto.rsp.AuthorizationRsp;

/**
 * @author XX
 * 
 */
public interface RemoteSafeKeyService {
    AuthorizationRsp auth(Authorization authorization, TxHeader header) throws Exception  ;
}
