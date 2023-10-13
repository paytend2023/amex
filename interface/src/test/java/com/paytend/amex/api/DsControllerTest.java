package com.paytend.amex.api;

import cn.hutool.json.JSONUtil;
import com.paytend.amex.facade.ds.RemoteDsService;
import com.paytend.amex.facade.ds.dto.SupportedVersionReqDto;
import com.paytend.amex.facade.ds.dto.SupportedVersionRspDto;
import com.paytend.amex.facade.tx.dto.TxHeader;
import com.paytend.amex.facade.tx.dto.req.Authorization;
import com.paytend.amex.facade.tx.dto.rsp.AuthorizationRsp;
import com.paytend.amex.service.DsService;
import com.paytend.amex.service.SafeKeyService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

/**
 * @author Sunny
 * @create 2023/9/15 13:20
 */

@Slf4j
@Configurable
@ExtendWith(MockitoExtension.class)
class DsControllerTest {
    @Mock
    public DsService dsService;


    @Test
    void supportedVersion() throws Exception {
        MvcResult mvcResult = null;
        SupportedVersionReqDto supportedVersionReqDto = new SupportedVersionReqDto();
        supportedVersionReqDto.setCardNo("375987000169800");
        supportedVersionReqDto.setNotificationURL("www.baidu.com");
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new DsController(dsService)).build();
        Mockito.when(dsService.supportedVersion(any(SupportedVersionReqDto.class))).thenReturn(new SupportedVersionRspDto());
        mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/ds/supportedVersion")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(JSONUtil.toJsonStr(supportedVersionReqDto))
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        log.info(mvcResult.getResponse().getContentAsString());
    }
}