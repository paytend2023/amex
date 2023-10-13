package com.paytend.amex.facade.tx.dto.req;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.experimental.Tolerate;

/**
 * @author XX
 * 
 */

@Getter
@Setter
@SuperBuilder
@ToString
public class BatchAdminRequest extends BaseSubmitRequest     {




    /**
     * Data Length: 2 bytes
     * Data Element Type: Numeric
     * Required Field: Yes
     * Description: This field indicates the operation this administration request message is issuing.
     * <p>
     * The valid values include:
     * 01 = Open
     * 02 = Close
     * 03 = Purge
     * 04 = Status
     * Note: American Express will close and process any batch left open for
     * over twenty-four (24) hours.
     * <p>
     * Example: <BatchOperation>01</BatchOperation>
     */
    protected String BatchOperation;

    /**
     * Data Length: 2 bytes
     * Data Element Type: Numeric
     * Required Field: No
     * <p>
     * Description: This field indicates whether the submitter has requested Batch Summary information be included in
     * the Batch Administration Response Message. This can be sent for any Batch Administration message but totals
     * are set to zero (0) for Batch Open and Batch Purge requests. If this is not provided, then a summary is not provided
     * in the Batch Administration Response message.
     * The valid values include:
     * 00 = No summary
     * 01 = Send summary
     */
    protected String ReturnBatchSummary;


    protected CardAcceptorDetail CardAcceptorDetail;

    /**
     * Data Length: 10 bytes 10 bytes, maximum
     * Data Element Type: Alphanumeric
     * Required Field:
     * Yes - If Batch Open and Batch Close messages
     * No - If Batch Purge and Batch Status messages
     * <p>
     * Description: A unique identifier code assigned by American Express to submitters so they can directly access
     * American Express to deliver real-time settlement data
     * <p>
     * Example: <SubmitterCode>1234567890</SubmitterCode>
     */
    protected String SubmitterCode;

    @Tolerate
    public BatchAdminRequest() {
    }


}
