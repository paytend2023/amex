package com.paytend.amex.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.paytend.amex.tx.TransCommUtils;
import com.paytend.amex.tx.XmlRequest;
import com.paytend.amex.tx.dto.TxHeader;
import com.paytend.amex.tx.dto.req.AuthorizationDto;
import com.paytend.amex.tx.dto.req.BatchAdminRequestDto;
import com.paytend.amex.tx.dto.req.DataCaptureRequestDto;
import com.paytend.amex.tx.dto.rsp.AuthorizationRspDto;
import com.paytend.amex.tx.dto.rsp.BatchRespDto;
import com.paytend.amex.tx.dto.rsp.DataCaptureRspDto;
import com.paytend.amex.tx.remote.RemoteAmexAuthService;
import com.paytend.amex.tx.req.Authorization;
import com.paytend.amex.tx.req.BatchAdminRequest;
import com.paytend.amex.tx.req.DataCaptureRequest;
import com.paytend.amex.tx.req.Header;
import com.paytend.amex.tx.rsp.AuthorizationRsp;
import com.paytend.amex.utils.XmlUtility;
import io.aexp.api.client.core.utils.JsonUtility;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * @author XX
 */
@Service
@Slf4j
public class RemoteAmexAuthServiceImpl implements RemoteAmexAuthService {

    @Value("${amex.auth.url: }")
    private String url;

    @PostConstruct
    public void postConstruct() {
        log.info(" authUrl: {} ", url);
    }

    //pe cs
    public <Req, Rsp> Rsp innerAuth(Req authorization, TxHeader txHeader, Class<? extends XmlRequest> clazz, TypeReference<Rsp> typeReference) throws Exception {
        JsonUtility jsonUtility = JsonUtility.getInstance();
        String json = jsonUtility.getString(authorization);
        log.info("reqJson:{}", json);
        XmlRequest auth = jsonUtility.getObject(json, clazz);
        Map<String, String> headMap = txHeader.convertToMap();
        headMap.put("url", url);
        String responseStr = TransCommUtils.getInstance().sendXml(url, auth, headMap);
        log.info("repXML:{}", responseStr);
        AuthorizationRsp response = XmlUtility.getInstance().readFromXML(responseStr, AuthorizationRsp.class);
        return jsonUtility.getObject(jsonUtility.getString(response), typeReference);
    }


    @Override
    public AuthorizationRspDto auth(AuthorizationDto authorization, TxHeader txHeader) throws Exception {
        return innerAuth(authorization, txHeader, Authorization.class, new TypeReference<AuthorizationRspDto>() {
        });
    }

    @Override
    public BatchRespDto batchAdmin(BatchAdminRequestDto batchAdminRequestDto, TxHeader header) throws Exception {
        return innerAuth(batchAdminRequestDto, header, BatchAdminRequest.class, new TypeReference<BatchRespDto>() {
        });
    }

    @Override
    public DataCaptureRspDto dataCapture(DataCaptureRequestDto dataCaptureRequest, TxHeader header) throws Exception {
        return innerAuth(dataCaptureRequest, header, DataCaptureRequest.class, new TypeReference<DataCaptureRspDto>() {
        });
    }
}
