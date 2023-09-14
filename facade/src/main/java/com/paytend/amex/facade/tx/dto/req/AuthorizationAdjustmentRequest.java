package com.paytend.amex.facade.tx.dto.req;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * @author Sunny
 * @create 2023/8/26 10:14
 */

@Getter
@Setter
@SuperBuilder
@ToString
public class AuthorizationAdjustmentRequest extends BaseFields {
    /**
     * bit 30
     * authorization adjustment 交易使用
     * authorization 不用上送
     * Data Length: 24 bytes, fixed
     * <p>
     * <p>
     * Description: This data element contains the Original Transaction Amount that was previously approved by
     * American Express.
     * Positions 1-12 of this data element are the original transaction amount from Bit 4, TransAmt
     * in the corresponding Authorization Response (1110) message.
     * Positions 13-24 are zero filled and reserved for future use.
     * This data element is mandatory for processing this message, and it will be preserved and returned in
     * the response message without alteration
     */
    String OrigTransAmt;


    /**
     * Description:
     * Note: This requirement applies to the container element and all related sub-elements.
     * This container element holds the sub-elements listed in the following example;
     * and the sub-elements must contain the same values used in the original Authorization Request (1100) message.
     */
    OriginalDataElements OriginalDataElements;


}
