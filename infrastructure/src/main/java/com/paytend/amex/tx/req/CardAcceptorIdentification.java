package com.paytend.amex.tx.req;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

/**
 * @author  XIXI
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
