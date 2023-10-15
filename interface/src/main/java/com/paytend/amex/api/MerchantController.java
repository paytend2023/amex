package com.paytend.amex.api;

import com.paytend.amex.CommonRsp;
import com.paytend.amex.mch.MerchantCommandService;
import com.paytend.amex.mch.dto.req.SePayLoadRequest;
import com.paytend.amex.mch.dto.resp.SellerResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XX
 */
@RestController
@RequestMapping(value = "merchant")
@Slf4j
public class MerchantController {

    private MerchantCommandService merchantCommandService;

    @PostMapping(path = "reportMerchant", produces = MediaType.APPLICATION_JSON_VALUE)
    public SellerResponse reportMerchant(@RequestBody SePayLoadRequest sePayLoadRequest) {
        log.info("reportMerchant>>>>>{}  ", sePayLoadRequest);
        SellerResponse rsp = merchantCommandService.reportMerchants(sePayLoadRequest);
        log.info("reportMerchant rsp>>>>>  {}", rsp);
        return rsp;
    }

    public MerchantController(MerchantCommandService merchantCommandService) {
        this.merchantCommandService = merchantCommandService;
    }
}
