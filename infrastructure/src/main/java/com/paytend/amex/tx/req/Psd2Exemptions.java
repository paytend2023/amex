package com.paytend.amex.tx.req;

import lombok.Data;
import lombok.experimental.Tolerate;

/**
 * @author XIXI
 */
@Data
public class Psd2Exemptions {
    String EuPsd2SecCorpPayInd;
    String AuthOutageInd;

    public Psd2Exemptions() {
    }
}
