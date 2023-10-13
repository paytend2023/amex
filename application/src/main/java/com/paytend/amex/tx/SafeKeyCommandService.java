package com.paytend.amex.tx;

import com.paytend.amex.tx.dto.TxHeader;
import com.paytend.amex.tx.dto.req.Authorization;
import com.paytend.amex.tx.dto.rsp.AuthorizationRsp;
import com.paytend.amex.tx.remote.RemoteSafeKeyService;
import com.paytend.exception.CallRemoteException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @author XX
 * 
 */
@Service
public class SafeKeyCommandService {
    @Resource
    private RemoteSafeKeyService remoteSafeKeyService;

    public AuthorizationRsp auth(Authorization authorization, TxHeader header) {
        try {
            return remoteSafeKeyService.auth(authorization, header);
        } catch (Exception e) {
            throw new CallRemoteException(e.getMessage(), e.getCause());
        }
    }

}
