package com.paytend.amex.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paytend.amex.api.model.NotifyVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.Base64;


/**
 * @author Sunny
 * @create 2023/9/19 09:43
 */
@Controller
@Slf4j
@RequestMapping(value = "view")

public class ViewController {

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private ObjectMapper jasonObjMapper;

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
}
