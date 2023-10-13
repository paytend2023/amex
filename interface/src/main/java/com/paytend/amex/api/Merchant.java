package com.paytend.amex.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author XX
 * 
 */
@Controller
@RequestMapping(value = "merchant")
public class Merchant {
    public String query(Long id) {
        return "";
    }
}
