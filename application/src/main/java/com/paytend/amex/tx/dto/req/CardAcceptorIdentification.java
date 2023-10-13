package com.paytend.amex.tx.dto.req;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

/**
 * @author gudongyang
 */
@Builder
@Getter
@Setter
public class CardAcceptorIdentification {

    String MerId;
    String IATAAirlineCd;
    String IATATravAgtId;

    @Tolerate
    public CardAcceptorIdentification() {
    }
}
