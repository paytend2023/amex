package com.paytend.amex.tx.dto.req;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.experimental.Tolerate;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

/**
 * @author XX
 */
@Setter
@Getter
@SuperBuilder

@Schema(
        type = "object", subTypes = {BatchAdminRequestDto.class, DataCaptureRequestDto.class}
)

public class BaseSubmitRequestDto {


    @Schema(description = " 第3域 版本号",
            requiredMode = REQUIRED,
            example = "12010000",
            type = "string",
            maxLength = 8,
            minLength = 8
    )
    /**
     * Field 3
     * Data Length: 8 bytes, fixed
     * Data Element Type: Numeric
     * Required Field: Yes
     * Description: This field contains the version number that corresponds to the messages created per this specification.
     * <p>
     * Example:<Version>12010000</Version>
     */
    protected String version;


    @Schema(description = " 第4域 SE 号和货币编号相关,一个机构一个货币一个SE",
            requiredMode = REQUIRED,
            example = "5021011432",
            type = "Integer",
            maxLength = 15
    )
    /**
     * Field 4
     * Data Length: 15 bytes, maximum
     * Data Element Type:  Numeric
     * Required Field: Yes
     * Description: This field contains the American Express-assigned Service Establishment (SE) Number that is used to
     * identify and pay Merchants.Each Merchant ID/SE Number can submit transactions in only one currency.
     * A Merchant that intends to submit multiple currencies must request one SE Number for each submission currency.
     * All Service Establishment Numbers should be validated and must pass the Mod 9 check. For details,
     * refer to Cardmember Number Identification in the American Express Global Codes & Information Guide.
     * <p>
     * Example:<MerId>5021011432</MerId>
     */
    protected String merId;


    @Schema(description = " 第5域 终端标识",
            requiredMode = REQUIRED,
            example = "5021011432",
            type = "Integer",
            maxLength = 8,
            name = "merTrmnlId"
    )
    /**
     * Field 5
     * Data Length: 8 bytes, maximum
     * Data Element Type: Alphanumeric, upper case
     * Required Field: Yes
     * Description: This field contains a unique code that identifies a specific terminal at a Merchant location.
     * <p>
     * Example:<MerTrmnlId>80000011</MerTrmnlId>
     */
    protected String merTrmnlId;



    @Schema(description = " 第6域 批次号 同一商户或者SE不能重复",
            requiredMode = REQUIRED,
            example = "502101",
            type = "Integer",
            maxLength = 6,
            name =""
    )
    /**
     * Data Length: 6 bytes, maximum
     * Data Element Type: Numeric
     * Required Field: Yes
     * <p>
     * Description: This field contains a unique Merchant- or submitter-assigned number
     * that identifies this batch.
     * <p>
     * Example:<BatchID>481035</BatchID>
     */
    protected String batchID;

    @Tolerate
    public BaseSubmitRequestDto() {
    }
}
