package com.paytend.ds.zf;

import com.paytend.amex.tx.dto.rsp.BatchRespDto;
import com.paytend.amex.utils.XmlUtility;
import io.aexp.api.client.core.utils.JsonUtility;
import org.junit.jupiter.api.Test;

/**
 * @author Sunny
 */
public class JSONTest {


    @Test
    public void testJSON() throws Exception {

        String str="<BatchAdminResponse>\n" +
                "  <Version>12010000</Version>\n" +
                "  <MerId>8127921740</MerId>\n" +
                "  <MerTrmnlId>100400</MerTrmnlId>\n" +
                "  <BatchID>200034</BatchID>\n" +
                "  <BatchStatus>006</BatchStatus>\n" +
                "  <BatchStatusText>226 Merchant ID Account Details Incomplete.</BatchStatusText>\n" +
                "</BatchAdminResponse>";


        BatchRespDto batchRespDto= XmlUtility.getInstance().readFromXML(str, BatchRespDto.class);


        String jsonString ="{\n" +
                "  \"version\" : \"12010000\",\n" +
                "  \"mer_id\" : \"8127921740\",\n" +
                "  \"mer_trmnl_id\" : \"100400\",\n" +
                "  \"batch_id\" : \"200035\",\n" +
                "  \"batch_status\" : \"006\",\n" +
                "  \"batch_status_text\" : \"226 Merchant ID Account Details Incomplete.\"\n" +
                "}";


        JsonUtility jsonUtility = JsonUtility.getInstance();
        jsonUtility.getObject(jsonString,BatchRespDto.class );
    }
}
