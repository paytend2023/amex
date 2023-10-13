package com.paytend.amex.start;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author XX
 * 
 */

@EnableJpaRepositories
@SpringBootApplication(scanBasePackages = {"com.paytend"})
 public class AmexApplication {
//    JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES,

    public static void main(String[] args) {
        SpringApplication.run(AmexApplication.class);
    }
}
