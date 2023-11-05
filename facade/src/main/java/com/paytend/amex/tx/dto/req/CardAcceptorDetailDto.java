package com.paytend.amex.tx.dto.req;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

/**
 * @author XIXI
 */


@Getter
@Builder
@Setter

@Schema(name = "cardAcceptorDetailDto", description = "接受卡者结构体",
        type = "object")
public class CardAcceptorDetailDto {
    @Tolerate
    public CardAcceptorDetailDto() {
    }


    @Schema(name = "cardAcptNm", description = "受卡者名称",
            type = "string", requiredMode = Schema.RequiredMode.REQUIRED, maxLength = 38)

    /**
     * Data Length: 38 bytes, maximum
     * Data Element Type: Alphanumeric, upper case
     * Required Field: Yes
     * Description:
     * This field contains the Merchant/Seller name that appears on the storefront and/or customer receipts,
     * commonly referred to as the “DBA” (Doing Business As) name.
     * This information will become part of the descriptive bill on the Cardmember's statement.
     * This name must be easily recognized by the Cardmember to avoid unnecessary inquiries.
     * If the name is more than 38 characters, use proper and meaningful abbreviation, when possible. Do not truncate.
     * Payment Facilitators and Bill Payment Providers Only
     * Payment Facilitators and Bill Payment Providers must use their Payment Facilitator or Bill Pay Provider business name
     * in conjunction with the name of the actual seller for whom the transaction is submitted.
     *
     *
     */
    protected String cardAcptNm;


    @Schema(name = "cardAcptStreetNm", description = "受卡者街道名称",
            type = "string", requiredMode = Schema.RequiredMode.REQUIRED, maxLength = 38)

    /**
     * Data Length: 38 bytes, maximum
     * Data Element Type: Alphanumeric, upper case
     * Required Field: Yes
     * Description:
     */
    protected String cardAcptStreetNm;


    /**
     * 21 bytes
     * Alphanumeric
     * Yes
     */
    @Schema(name = "cardAcptCityNm", description = "受卡者城市", type = "string",
            requiredMode = Schema.RequiredMode.REQUIRED, maxLength = 21)

    protected String cardAcptCityNm;


    /**
     * 3 bytes
     * Alphanumeric
     * Yes
     */

    @Schema(name = "cardAcptCtryCd", description = "国家代码840 美国", type = "integer",
            requiredMode = Schema.RequiredMode.REQUIRED, maxLength = 3)
    protected String cardAcptCtryCd;

    @Schema(name = "cardAcptRgnCd",
            description = "城市代码 可以查询     American Express Global Codes & Information Guide",
            type = "string", requiredMode = Schema.RequiredMode.REQUIRED, maxLength = 3)

    /**
     * 3 bytes
     * Alphanumeric
     * Yes
     */
    protected String cardAcptRgnCd;

    /**
     * 15 bytes
     * Alphanumeric
     * No
     */
    @Schema(name = "name", hidden = true)
    protected String cardAcptPostCd;
}
