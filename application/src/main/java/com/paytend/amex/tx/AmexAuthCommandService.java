package com.paytend.amex.tx;

import com.paytend.amex.tx.dto.TxHeader;
import com.paytend.amex.tx.dto.req.AuthorizationDto;
import com.paytend.amex.tx.dto.req.BatchAdminRequestDto;
import com.paytend.amex.tx.dto.req.DataCaptureRequestDto;
import com.paytend.amex.tx.dto.rsp.AuthorizationRspDto;
import com.paytend.amex.tx.dto.rsp.BatchRespDto;
import com.paytend.amex.tx.dto.rsp.DataCaptureRspDto;
import com.paytend.amex.tx.remote.RemoteAmexAuthService;
import com.paytend.exception.CallRemoteException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @author XX
 * 
 */
@Service
public class AmexAuthCommandService {
    @Resource
    private RemoteAmexAuthService remoteAmexAuthService;

    public AuthorizationRspDto auth(AuthorizationDto authorization, TxHeader header) {
        try {
            return remoteAmexAuthService.auth(authorization, header);
        } catch (Exception e) {
            throw new CallRemoteException(e.getMessage(), e.getCause());
        }
    }

    public BatchRespDto batchAdmin(BatchAdminRequestDto batchAdminRequestDto, TxHeader header) {
        try {
            return remoteAmexAuthService.batchAdmin(batchAdminRequestDto, header);
        } catch (Exception e) {
            throw new CallRemoteException(e.getMessage(), e.getCause());
        }
    }

    public DataCaptureRspDto dataCapture(DataCaptureRequestDto dataCaptureRequest, TxHeader header) {
        try {
            return remoteAmexAuthService.dataCapture(dataCaptureRequest, header);
        } catch (Exception e) {
            throw new CallRemoteException(e.getMessage(), e.getCause());
        }
    }
}
