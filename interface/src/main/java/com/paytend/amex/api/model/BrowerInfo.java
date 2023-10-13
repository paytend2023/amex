package com.paytend.amex.api.model;

import lombok.Data;

/**
 * @author Sunny
 * @create 2023/9/19 13:29
 */
@Data
public class BrowerInfo {

    private String browserAcceptHeader;
    private String browserIP;
    private String browserJavaEnabled;
    private String browserLanguage;
    private String browserScreenHeight;
    private String browserScreenWidth;
    private String browserColorDepth;
}
