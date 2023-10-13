package com.paytend.amex.start;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author XX
 */

@SpringBootApplication(scanBasePackages = {"com.paytend.amex","com.paytend"})
public class AmexApplication {
    public static void main(String[] args) {
        SpringApplication.run(AmexApplication.class);
    }
}
