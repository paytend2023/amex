package com.paytend.amex.api;

import com.paytend.amex.CommonRsp;
import com.paytend.amex.tx.dto.req.AuthorizationDto;
import com.paytend.amex.tx.dto.rsp.AuthorizationRspDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.Resource;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.LocalTime;
import java.time.ZoneId;

/**
 * @author Sunny
 */
@SpringBootTest(classes = {RestTemplate.class})
public class TxControllerSpringTest {

    @Resource
    RestTemplate restTemplate;

    @Test
    public void testNCP() {
        String url = "http://localhost:8080/tx/auth";
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(url);
        URI uri = uriComponentsBuilder.build().encode(StandardCharsets.UTF_8).toUri();

        //1.请求头
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.parseMediaType("application/json; charset=UTF-8"));
        httpHeaders.add("Accept", MediaType.APPLICATION_JSON.toString());
        httpHeaders.add("origin", "Paytend");
        httpHeaders.add("country", "276");
        httpHeaders.add("region", "EMEA");
        httpHeaders.add("merchNbr", "3285220521");
        httpHeaders.add("message", "XML GCAG");
        httpHeaders.add("rtInd", "050");


        AuthorizationDto da = AuthorizationDto.builder().build();


        //3.响应体
        ResponseEntity<CommonRsp<AuthorizationRspDto>> responseEntity = null;

        //4.发送post请求
        RequestEntity<AuthorizationDto> requestEntity = RequestEntity
                .post(uri)
                .header("Accept", MediaType.APPLICATION_JSON.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(da); //也可以是DTO

        try {
            responseEntity = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<CommonRsp<AuthorizationRspDto>>() {
            });
        } catch (RestClientException e) {
            e.printStackTrace();

        }


    }

    @Test
    public void testTimeZone() throws Exception {

        System.out.println(ZoneId.of("+08:00"));
        LocalTime time = LocalTime.now(ZoneId.of("+08:00"));
        System.out.println(time);
        LocalTime defaultTime = LocalTime.now(ZoneId.of("+08:00"));
        System.out.println(defaultTime);
    }


}
