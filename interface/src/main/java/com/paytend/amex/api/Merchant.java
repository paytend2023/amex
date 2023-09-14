package com.paytend.amex.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Sunny
 * @create 2023/9/10 13:36
 */
@Controller
@RequestMapping(value = "merchant")
public class Merchant {
    public String query(Long id) {
        return "";
    }
}
