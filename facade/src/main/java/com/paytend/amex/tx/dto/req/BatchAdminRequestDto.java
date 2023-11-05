package com.paytend.amex.tx.dto.req;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.experimental.Tolerate;

/**
 * @author XX
 */

@Getter
@Setter
@SuperBuilder

@Schema(description = "批次管理实体")
public class BatchAdminRequestDto extends BaseSubmitRequestDto {

    @Schema(description = "01 开批次  02 关闭批次  04批次查询 ", name = "batchOperation", requiredMode = Schema.RequiredMode.REQUIRED)
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
    protected String batchOperation;


    @Schema(hidden = true, name = "returnBatchSummary", requiredMode = Schema.RequiredMode.NOT_REQUIRED)

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
    protected String returnBatchSummary;


    @Schema(description = "商户信息数据", name = "cardAcceptorDetail",
            type = "object", requiredMode = Schema.RequiredMode.REQUIRED)

    protected CardAcceptorDetailDto cardAcceptorDetail;

    @Schema(description = " SE编号 ", name = "submitterCode", requiredMode = Schema.RequiredMode.REQUIRED)
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
    protected String submitterCode;

    @Tolerate
    public BatchAdminRequestDto() {
    }

}
