package com.paytend.amex.tx.dto.req;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Sunny
 */
@Getter
@Setter
public class VISAPS2000TransactionDto {
    String VISAPS2000QlfyTransInd;
    String AddVISASubElemValTxt;
}
