package com.paytend.amex.api;

import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paytend.amex.api.vo.NotifyVo;

import com.paytend.amex.ds.dto.SupportedVersionReqDto;
import com.paytend.amex.ds.dto.SupportedVersionRspDto;
import com.paytend.amex.CommonRsp;
import com.paytend.amex.ds.DsCommandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Base64;

//import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


/**
 * @author XX
 */
@Controller
@Slf4j
@RequestMapping(value = "view")

public class ViewController {

    @Resource
    private ObjectMapper jasonObjMapper;
    @Resource
    public DsCommandService dsCommandService;

    @RequestMapping(path = "supportedVersionNotify/{cardAsn}", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView receiveNotify(@RequestParam("threeDSMethodData") String data,
                                      @PathVariable("cardAsn") String cardAsn,
                                      @RequestHeader HttpHeaders headers

    ) throws JsonProcessingException {
        log.info("{}", jasonObjMapper);
        log.info("data: {}", data);
        headers.forEach((k, v) -> log.info("header {}={}", k, v));
        String tmp = new String(Base64.getDecoder().decode(data));
        log.info("tmp: [{}]", tmp);
        NotifyVo vo = jasonObjMapper.readValue(tmp, NotifyVo.class);
        vo.setCardAsn(cardAsn);
        log.info("view object:{}", vo);
        ModelAndView result = new ModelAndView();
        result.addObject("notifyVo", vo);
        result.setViewName("auth");
        return result;
    }

    @RequestMapping(path = "supportedVersion",  method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView supportedVersion(@RequestParam("cardNo") String cardAsn) {
        SupportedVersionReqDto versionReqDto = new SupportedVersionReqDto();
        versionReqDto.setCardNo(cardAsn);
        SupportedVersionRspDto rsp = dsCommandService.supportedVersion(versionReqDto);
        log.info("rsp:{}", JSONUtil.toJsonStr(CommonRsp.OK(rsp)));
        ModelAndView result = new ModelAndView();
        if (rsp.getThreeDSMethodURL() == null) {
            NotifyVo notifyRet = new NotifyVo();
            notifyRet.setCardAsn(cardAsn);
            notifyRet.setThreeDsServerTransId(rsp.getThreeDSServerTransID());
            result.addObject("notifyVo", notifyRet);
            result.setViewName("auth");
        } else {
            result.addObject("data", rsp);
            result.setViewName("auto_submit");
        }
        return result;
    }
}
