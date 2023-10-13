package com.paytend.amex.start;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Sunny
 * @create 2023/9/9 17:28
 */

@SpringBootApplication(scanBasePackages = {"com.paytend"})
 public class AmexApplication {
    @Autowired
    ObjectMapper objectMapper;

//    JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES,

    public static void main(String[] args) {
        SpringApplication.run(AmexApplication.class);
    }
}
