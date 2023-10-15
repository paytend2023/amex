import com.paytend.amex.tx.dto.TxHeader;
import com.paytend.amex.tx.dto.req.BatchAdminRequestDto;
import com.paytend.amex.tx.dto.req.CardAcceptorDetailDto;
import com.paytend.amex.tx.dto.req.DataCaptureRequestDto;
import com.paytend.amex.tx.dto.req.PointOfServiceDataDto;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Map;


/**
 * eclipse 语法提示太差  字段太多在这里拼好报文拷贝过去
 *
 * @author Xixi
 */
public class TestAmexAuth {

    CardAcceptorDetailDto.CardAcceptorDetailDtoBuilder
            cardAcceptorDetailBuilder = CardAcceptorDetailDto.builder()
            .CardAcptNm("PAYTEND EUROPE UAB")
            .CardAcptStreetNm("Vilnius City sav")
            .CardAcptCityNm("Vilnius")
            .CardAcptPostCd("01113")
            .CardAcptRgnCd("58")
            .CardAcptCtryCd("440");

    @Test
    public void testBatchDataOpen() {
        int batchID = 100012;
        int version = 12010000;
        String merId = "8127921740";
        String termId = "00000001";
        String submitterCode = "8038464327";

//            logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> batchOpen:"+batchID );
        BatchAdminRequestDto batchOpen = BatchAdminRequestDto.builder()
                .Version(String.valueOf(version))
                .MerId(merId)
                .BatchID(String.valueOf(batchID))
                .MerTrmnlId(termId)
                //open
                .BatchOperation("01")
                .CardAcceptorDetail(cardAcceptorDetailBuilder.build())
                .SubmitterCode(submitterCode)
                .build();

        //测试结算参数
        TxHeader txHeader = TxHeader.builder()
                .origin("Paytend")
                .country("276")
                .region("EMEA")
                .merchNbr("merchNbr")
                .message("GFSG XML BAR")
                .rtInd("015").build();

        //测试交易参数
        TxHeader txHeader1 = TxHeader.builder().origin("Paytend")
                .country("276")
                .region("EMEA")
                .message("XML GCAG")
                .merchNbr("3285220521")
                .rtInd("050").build();

        txHeader.convertToMap();

//            send(batchOpen, header);
//            logger.debug("batchOpenResp:{}", batchResp);

    }

    @Test
    public void testBatchDataClose() throws Exception {
        int batchID = 100012;
        int version = 12010000;
        String merId = "8127921740";
        String termId = "00000001";
        String submitterCode = "8038464327";
        String respXml = null;
        BatchAdminRequestDto batchClosed = BatchAdminRequestDto.builder()
                .Version(String.valueOf(version))
                .MerId(merId)
                .BatchID(String.valueOf(batchID))
                .MerTrmnlId(termId)
                //close
                .BatchOperation("02")
                .CardAcceptorDetail(cardAcceptorDetailBuilder.build())
                .SubmitterCode(submitterCode)
                .build();

        //测试结算参数
        TxHeader txHeader = TxHeader.builder()
                .origin("Paytend")
                .country("276")
                .region("EMEA")
                .merchNbr("merchNbr")
                .message("GFSG XML BAR")
                .rtInd("015").build();
    }



    @Test
    public void testDataCaptureRequest() throws Exception {
        int batchID = 100012;
        int version = 12010000;
        String merId = "8127921740";
        String termId = "00000001";
        String RefNumber = "000003";
        //debit 000000 credit 200000
        String TransProcCd = "200000";
        String TransId = "000002533594384";
        String TransAprvCd="594384";

        PointOfServiceDataDto.PointOfServiceDataDtoBuilder pointOfServiceDataBuilder = PointOfServiceDataDto.builder()
                .CardDataInpCpblCd("1")
                .CMAuthnCpblCd("6")
                .CardCptrCpblCd("0")
                .OprEnvirCd("0")
                .CMPresentCd("3")
                .CardPresentCd("0")
                .CardDataInpModeCd("1")
                .CMAuthnMthdCd("0")
                .CMAuthnEnttyCd("0")
                .CardDataOpCpblCd("0")
                .TrmnlOpCpblCd("1")
                .PINCptrCpblCd("0");

        DataCaptureRequestDto dataCaptureRequest = DataCaptureRequestDto.builder()
                .Version(String.valueOf(version))
                .MerId(merId)
                .BatchID(String.valueOf(batchID))
                .MerTrmnlId(termId)
                .RefNumber(RefNumber)
                .CardNbr(374500261001009L)
                //yyyyMMdd
                .TransDt("20231015")
                .TransAmt(1600)
                //Euro
                .TransCurrCd("978")
                .TransProcCd(TransProcCd)
                .TransId(TransId)  //交易唯一标识
                .ElecComrceInd("05")
                .TransAprvCd(TransAprvCd) //授权码
                .PointOfServiceData(pointOfServiceDataBuilder.build())
//                .DefPaymentPlan("0005")
                .MerCtgyCd("4111")
                .SellId("1234QR7890")
                .build();

        Map<String, String> dataCaptureHeaders = TxHeader.builder()
                .origin("Paytend")
                .country("276")
                .region("EMEA")
                .message("GFSG XML DCR")
                .merchNbr("3285220521")
                .rtInd("015")
                .build().convertToMap();
    }
}
