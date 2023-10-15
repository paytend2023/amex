package com.paytend.amex.mch.dto.req;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import lombok.experimental.Tolerate;

/**
 * @author  XIXI
 */
@SuperBuilder
@Getter
public class AuthorizedSigner extends Owner {

    /**
     * title
     * string, max: 20 OPTIONAL
     * This alphanumeric field contains the job title or office of the Seller's Authorized Signer.
     * Example: CEO, CFO, President, Owner etc.
     */
    String title;

    @Tolerate
    public AuthorizedSigner( ) {

    }
}
