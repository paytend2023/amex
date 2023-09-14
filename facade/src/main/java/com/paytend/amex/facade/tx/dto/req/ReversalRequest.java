package com.paytend.amex.facade.tx.dto.req;


import lombok.Getter;
import lombok.Setter;

/**
 * @author Sunny
 * @create 2023/8/25 15:16
 */

@Setter
@Getter
public class ReversalRequest extends BaseFields  {

    /**
     * Description:
     * Note: This requirement applies to the container element and all related sub-elements.
     * This container element holds the sub-elements listed in the following example;
     * and the sub-elements must contain the same values used in the original Authorization Request (1100) message.
     */
    OriginalDataElements OriginalDataElements;


    public ReversalRequest(OriginalDataElements originalDataElements, Authorization authorization) {
//        BeanUtil.copyProperties(authorization, this);
        this.OriginalDataElements = originalDataElements;
    }
}
