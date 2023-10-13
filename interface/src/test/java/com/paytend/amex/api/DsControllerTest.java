package com.paytend.amex.api;

import cn.hutool.json.JSONUtil;

import com.paytend.amex.ds.DsCommandService;
import com.paytend.amex.facade.ds.dto.SupportedVersionReqDto;
import com.paytend.amex.facade.ds.dto.SupportedVersionRspDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;

/**
 * @author XX
 * 
 */

@Slf4j
@Configurable
@ExtendWith(MockitoExtension.class)
class DsControllerTest {
    @Mock
    public DsCommandService dsCommandService;


    @Test
    void supportedVersion() throws Exception {
        MvcResult mvcResult = null;
        SupportedVersionReqDto supportedVersionReqDto = new SupportedVersionReqDto();
        supportedVersionReqDto.setCardNo("375987000169800");
        supportedVersionReqDto.setNotificationURL("www.baidu.com");
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new DsController(dsCommandService)).build();
        Mockito.when(dsCommandService.supportedVersion(any(SupportedVersionReqDto.class))).thenReturn(new SupportedVersionRspDto());
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