package com.paytend.amex.mch;

import com.paytend.amex.mch.dto.req.SePayLoadRequest;

import com.paytend.amex.mch.dto.resp.SellerResponse;
import com.paytend.amex.mch.remote.RemoteMerchantService;
import com.paytend.exception.CallRemoteException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;


/**
 * @author Sunny
 */
@Service
@Slf4j
public class MerchantCommandService {

    public RemoteMerchantService remoteMerchantService;

    /**
     * 进件接口
     *
     * @param sePayLoadRequest
     * @return
     */
    public SellerResponse reportMerchants(SePayLoadRequest sePayLoadRequest) {
        try {
            return remoteMerchantService.reportMerchants(sePayLoadRequest);
        } catch (IOException e) {
            log.error("call sm api", e);
            throw new CallRemoteException("call sm api exception:", e);
        }

    }

    public MerchantCommandService(RemoteMerchantService remoteMerchantService) {
        this.remoteMerchantService = remoteMerchantService;
    }
}
