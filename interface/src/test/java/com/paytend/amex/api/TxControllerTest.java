package com.paytend.amex.api;


import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.paytend.amex.facade.tx.dto.TxHeader;
import com.paytend.amex.facade.tx.dto.req.Authorization;
import com.paytend.amex.facade.tx.dto.rsp.AuthorizationRsp;
import com.paytend.amex.service.SafeKeyService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashMap;

import static org.mockito.ArgumentMatchers.any;


/**
 * @author XX
 *
 */
@Slf4j
@Configurable
@ExtendWith(MockitoExtension.class)
class TxControllerTest {

    @Mock
    public SafeKeyService safeKeyService;

    @InjectMocks
    public TxController txController;

    @Test
    public void auth() {
        Authorization authorization = new Authorization();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new TxController(safeKeyService)).build();
        MvcResult mvcResult = null;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("origin", "Paytend");
        httpHeaders.add("country", "276");
        httpHeaders.add("region", "EMEA");
        httpHeaders.add("merchnbr", "3285220521");

        try {

            authorization.setAcqInstCtryCd("123");

            Mockito.when(safeKeyService.auth(any(Authorization.class), any(TxHeader.class))).thenReturn(new AuthorizationRsp());

            mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/tx/auth")
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON)
                            .content(JSONUtil.toJsonStr(authorization))
                            .headers(httpHeaders)
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andReturn();
            log.info(mvcResult.getResponse().getContentAsString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    static ObjectMapper mapper;

    @BeforeAll
    static void setup() {
        mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    @Test
    public void auth1() throws JsonProcessingException {
        String jsonString = "{\"msgTypId\":\"1100\",\"cardNbr\":\"374500261001009\",\"transProcCd\":\"004000\",\"cardExprDt\":\"2501\",\"acqInstCtryCd\":\"276\",\"pointOfServiceData\":{\"cardDataInpCpblCd\":\"1\",\"cmauthnCpblCd\":\"6\",\"cardCptrCpblCd\":\"0\",\"oprEnvirCd\":\"0\",\"cmpresentCd\":\"1\",\"cardPresentCd\":\"0\",\"cardDataInpModeCd\":\"1\",\"cmauthnMthdCd\":\"0\",\"cmauthnEnttyCd\":\"0\",\"cardDataOpCpblCd\":\"0\",\"trmnlOpCpblCd\":\"1\",\"pincptrCpblCd\":\"0\"},\"funcCd\":\"100\",\"msgRsnCd\":\"1900\",\"merCtgyCd\":\"4111\",\"rtrvRefNbr\":\"230913123622\",\"merTrmnlId\":\"00000001\",\"cardAcceptorDetail\":{\"cardAcptNm\":\"PAYTEND EUROPE UAB\",\"cardAcptStreetNm\":\"Vilnius City sav\",\"cardAcptCityNm\":\"Vilnius\",\"cardAcptCtryCd\":\"440\",\"cardAcptRgnCd\":\"58\",\"cardAcptPostCd\":\"01113\"},\"transCurrCd\":\"978\",\"acptEnvData\":{\"psd2Exemptions\":{\"euPsd2SecCorpPayInd\":\"0\",\"authOutageInd\":\"0\"},\"initPartyInd\":\"1\"},\"transAmt\":\"1600\",\"merSysTraceAudNbr\":\"300841\",\"transTs\":\"230913123622\",\"cardAcceptorIdentification\":{\"merId\":\"8127921740\"},\"additionalDataNational\":{\"cardNotPresentData\":{\"custEmailAddr\":\"king.gu@gmail.com\",\"custHostServerNm\":\"www.baidu.com\",\"custBrowserTypDescTxt\":\"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7)\",\"shipToCtryCd\":\"440\",\"shipMthdCd\":\"01\",\"merSKUNbr\":\"TKDC315U\",\"custIPAddr\":\"127.142.5.56\",\"custIdPhoneNbr\":\"13651654626\",\"callTypId\":\"61\"}},\"secureAuthenticationSafeKey\":{\"scndIdCd\":\"ASK\",\"elecComrceInd\":\"05\",\"aesktransId\":\"3132333435363738393031323334353637383930\",\"amexExpVerificationValTxt\":\"0000010567123487637946538663470000000000\"}}";

        Authorization authorization = mapper.readValue(jsonString, Authorization.class);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new TxController(safeKeyService)).build();

        MvcResult mvcResult = null;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("origin", "Paytend");
        httpHeaders.add("country", "276");
        httpHeaders.add("region", "EMEA");
        httpHeaders.add("merchnbr", "3285220521");


        try {
            Mockito.when(safeKeyService.auth(any(Authorization.class), any(TxHeader.class))).thenReturn(new AuthorizationRsp());
            mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/tx/auth")
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON)
                            .content(jsonString).characterEncoding("utf-8")
                            .headers(httpHeaders)
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andReturn();
            log.info(mvcResult.getResponse().getContentAsString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}