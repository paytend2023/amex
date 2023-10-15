package com.paytend.amex.tx;

/**
 * @author xixi
 * @create 2023/8/22 21:45
 */
public interface XmlRequest {
    /**
     * 生成请求的xml
     *
     * @return xmlStr
     */
    String toXml();
}
