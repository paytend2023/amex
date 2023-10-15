package com.paytend.amex.tx.remote;

import com.paytend.amex.tx.dto.TxHeader;
import com.paytend.amex.tx.dto.req.AuthorizationDto;
import com.paytend.amex.tx.dto.req.BatchAdminRequestDto;
import com.paytend.amex.tx.dto.req.DataCaptureRequestDto;
import com.paytend.amex.tx.dto.rsp.AuthorizationRspDto;
import com.paytend.amex.tx.dto.rsp.BatchRespDto;
import com.paytend.amex.tx.dto.rsp.DataCaptureRspDto;

/**
 * @author XX
 */
public interface RemoteAmexAuthService {
    /**
     * @param authorization 授权交易
     * @param header
     * @return
     * @throws Exception
     */
    AuthorizationRspDto auth(AuthorizationDto authorization, TxHeader header) throws Exception;

    BatchRespDto batchAdmin(BatchAdminRequestDto batchAdminRequestDto, TxHeader header) throws Exception;

    DataCaptureRspDto dataCapture(DataCaptureRequestDto dataCaptureRequest, TxHeader header) throws Exception;
}
