package com.paytend.amex.mch.remote;

import com.paytend.amex.mch.dto.req.SePayLoadRequest;
import com.paytend.amex.mch.dto.resp.SellerResponse;

import java.io.IOException;

/**
 * @author xxxx
 */
public interface RemoteMerchantService {
    /**
     * 进件接口
     *
     * @param sePayLoadRequest 请求
     * @return 进件结果
     * @throws IOException 通讯异常
     */
    SellerResponse reportMerchants(SePayLoadRequest sePayLoadRequest) throws IOException;

}
