package com.paytend.ds;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

//import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * @author xxx
 */
@Data
//@Table(name = "tbl_ds_order")
public class DsOrderPo {
    @Id
    private String id;


    /**
     * header部分
     * 请求唯一流水
     */

    private String threeDsServerTransId;

    /**
     * header 部分
     * 商户号
     */
    private String merNo;

    /**
     * 卡号
     */
    private String acctNumber;

    /**
     * 目前保存SE编号
     */
    private String acquirerBin;

    private String acquirerMerchantId;

    @CreatedDate
    private LocalDateTime createTime;

    @LastModifiedDate
    private LocalDateTime updateTime;
}
