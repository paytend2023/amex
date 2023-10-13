package com.paytend.amex.service;

import com.paytend.amex.tx.dto.TxHeader;
import com.paytend.amex.tx.dto.req.Authorization;
import com.paytend.amex.tx.dto.rsp.AuthorizationRsp;
import com.paytend.amex.tx.remote.RemoteSafeKeyService;
import com.paytend.amex.tx.dto.req.Header;
import com.paytend.amex.tx.TransCommUtils;
import io.aexp.api.client.core.utils.JsonUtility;
import com.paytend.amex.utils.XmlUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author XX
 * 
 */
@Service
public class RemoteSafeKeyServiceImpl implements RemoteSafeKeyService {
    static final Logger LOGGER = LoggerFactory.getLogger(RemoteSafeKeyServiceImpl.class);


    //todo 配置
    private static final String URL = "https://qwww318.americanexpress.com/IPPayments/inter/CardAuthorization.do";


    @Override
    public AuthorizationRsp auth(Authorization authorization, TxHeader txHeader) throws Exception {
        String str = JsonUtility.getInstance().getString(authorization);
        com.paytend.amex.tx.dto.req.Authorization author =
                JsonUtility.getInstance().getObject(str, com.paytend.amex.tx.dto.req.Authorization.class);
        LOGGER.info("AuthorizationRsp begin request: {}", author.toXml());
        Header header = Header.builder().message("XML GCAG").rtInd("050").host(URL)
                .merchNbr(Optional.of(txHeader.getMerchNbr()).get())
                .region(Optional.of(txHeader.getRegion()).get())
                .country(Optional.of(txHeader.getCountry()).get())
                .origin(Optional.of(txHeader.getOrigin()).get()).build();
        String responseStr = TransCommUtils.sendXml(URL, author, header.buildHeaders());
        LOGGER.info("AuthorizationRsp end response: [{}]", responseStr);
        com.paytend.amex.tx.dto.rsp.AuthorizationRsp response =
                XmlUtility.getInstance().readFromXML(responseStr, com.paytend.amex.tx.dto.rsp.AuthorizationRsp.class);
        String tmp = JsonUtility.getInstance().getString(response);
        return JsonUtility.getInstance().getObject(tmp, AuthorizationRsp.class);
    }


}
