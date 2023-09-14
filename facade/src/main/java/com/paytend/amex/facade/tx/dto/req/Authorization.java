package com.paytend.amex.facade.tx.dto.req;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.experimental.Tolerate;

/**
 * @author gudongyang
 */
@SuperBuilder
@Getter
@Setter
@ToString(callSuper = true)
public class Authorization extends BaseFields   {


    /**
     * bit 62
     */
    @Setter(AccessLevel.NONE)
    private ValidationInformation62 validationInformation;
    /**
     * bit 63
     * todo
     */
    @Setter(AccessLevel.NONE)
    private VerificationInformation63 validationInformation63;


    @Tolerate
    public Authorization() {
    }

}
