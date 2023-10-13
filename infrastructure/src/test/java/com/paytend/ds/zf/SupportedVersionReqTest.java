package com.paytend.ds.zf;

import com.paytend.amex.facade.ds.dto.SupportedVersionReqDto;
import org.junit.jupiter.api.Test;


/**
 * @author XX
 * 
 */

class SupportedVersionReqTest {

    @Test
    public void toJson() {

        SupportedVersionReqDto req = SupportedVersionReqDto.builder()
                .cardNo("375987000169800")
                .notificationURL("www.baidu.com")
                .build();
        System.out.println(req);
    }

}