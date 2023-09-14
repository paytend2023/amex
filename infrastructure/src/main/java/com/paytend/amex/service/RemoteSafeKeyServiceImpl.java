package com.paytend.amex.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.paytend.amex.facade.tx.dto.TxHeader;
import com.paytend.amex.facade.tx.dto.req.Authorization;
import com.paytend.amex.facade.tx.dto.rsp.AuthorizationRsp;
import com.paytend.amex.remote.RemoteSafeKeyService;
import com.paytend.amex.models.trans.req.Header;
import com.paytend.amex.models.trans.req.TransCommUtils;
import io.aexp.api.client.core.utils.JsonUtility;
import io.aexp.api.client.core.utils.XmlUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Sunny
 * @create 2023/9/11 21:21
 */
@Service
public class RemoteSafeKeyServiceImpl implements RemoteSafeKeyService {
    static final Logger LOGGER = LoggerFactory.getLogger(RemoteSafeKeyServiceImpl.class);


    //todo 配置
    private static final String URL = "https://qwww318.americanexpress.com/IPPayments/inter/CardAuthorization.do";


    @Override
    public AuthorizationRsp auth(Authorization authorization, TxHeader txHeader) throws Exception {
        String str = JsonUtility.getInstance().getString(authorization);
        com.paytend.amex.models.trans.req.Authorization author =
                JsonUtility.getInstance().getObject(str, com.paytend.amex.models.trans.req.Authorization.class);
        LOGGER.info("AuthorizationRsp begin request: {}", author.toXml());
        Header header = Header.builder().message("XML GCAG").rtInd("050").host(URL)
                .merchNbr(Optional.of(txHeader.getMerchNbr()).get())
                .region(Optional.of(txHeader.getRegion()).get())
                .country(Optional.of(txHeader.getCountry()).get())
                .origin(Optional.of(txHeader.getOrigin()).get()).build();
        String responseStr = TransCommUtils.sendXml(URL, author, header.buildHeaders());
        LOGGER.info("AuthorizationRsp end response: [{}]", responseStr);
        com.paytend.amex.models.trans.rsp.AuthorizationRsp response =
                XmlUtility.getInstance().readFromXML(responseStr, com.paytend.amex.models.trans.rsp.AuthorizationRsp.class);
        String tmp = JsonUtility.getInstance().getString(response);
        return JsonUtility.getInstance().getObject(tmp, AuthorizationRsp.class);
    }


}
