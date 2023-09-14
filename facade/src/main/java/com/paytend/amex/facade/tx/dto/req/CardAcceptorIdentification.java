package com.paytend.amex.facade.tx.dto.req;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Tolerate;

/**
 * @author gudongyang
 */
@Builder
@Getter
@Setter
@ToString
public class CardAcceptorIdentification {

    String merId;
    String IATAAirlineCd;
    String IATATravAgtId;

    @Tolerate
    public CardAcceptorIdentification() {
    }
}
