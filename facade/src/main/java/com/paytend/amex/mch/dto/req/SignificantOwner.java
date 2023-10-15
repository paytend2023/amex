package com.paytend.amex.mch.dto.req;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Tolerate;

/**
 * @author  XIXI
 */
@Builder
@Getter
public class SignificantOwner {
    @Tolerate
    public SignificantOwner() {
    }

    /**
     * first_owner
     * object REQUIRED
     * This common model will be used for both,
     * Authorized Signer and Significant Owner sections, as they share common attributes.
     */
    Owner firstOwner;

    /**
     * second_owner
     * object REQUIRED
     * This common model will be used for both,
     * Authorized Signer and Significant Owner sections, as they share common attributes.
     */
    Owner secondOwner;


    /**
     * third_owner
     * object REQUIRED
     * This common model will be used for both, Authorized Signer and Significant Owner sections,
     * as they share common attributes.
     */
    Owner thirdOwner;

    /**
     * fourth_owner
     * object REQUIRED
     * This common model will be used for both, Authorized Signer and Significant Owner sections,
     * as they share common attributes.
     */
    Owner fourthOwner;

}
