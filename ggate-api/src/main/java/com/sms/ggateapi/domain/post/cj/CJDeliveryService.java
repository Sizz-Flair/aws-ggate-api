package com.sms.ggateapi.domain.post.cj;

import com.sms.ggate.domain.doc.service.DocNoCJService;
import com.sms.ggateapi.domain.post.DeliveryService;
import com.sms.ggateapi.domain.post.cj.dto.ReportLabelDto;
import com.sms.ggateapi.util.JsonUtil;
import lombok.RequiredArgsConstructor;
import org.giant.api.domain.delivery.cj.CJApiFacade;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Map;

/**
 * Cj delivery service 클래스.
 * * <p>역할:
 * * <p>상속: PsiClass:Object
 * * <p>구현 인터페이스:
 * - PsiClass:DeliveryService
 * * @author YourName
 *
 * @since 2025 -09-07
 */
@Service("cj")
@RequiredArgsConstructor
public class CJDeliveryService implements DeliveryService {

    private final DocNoCJService docNoCJService;
    private final CJApiFacade cjApiFacade;

    @Override
    public String getDeliveryNum() {
        return docNoCJService.getInvoiceNumber();
    }

    @Override
    public String getZipCode(@NonNull String... data) {
        Assert.notEmpty(data, "data must not be empty");
        final String orderNo = data[0];
        final String address = data[1];

        try {
            return cjApiFacade.callZipCode(orderNo, address)
                    .map(zip ->
                            ReportLabelDto.builder()
                                    .PRINT_LABEL1(zip.getDlvClsfCd())
                                    .PRINT_LABEL2(zip.getDlvSubClsfCd())
                                    .PRINT_LABEL3(zip.getRcvrClsfAddr())
                                    .PRINT_LABEL4(zip.getDlvPreArrBranNm())
                                    .PRINT_LABEL5(zip.getDlvPreArrEmpNm())
                                    .PRINT_LABEL6(zip.getDlvPreArrEmpNickNm())
                                    .PRINT_LABEL7(zip.getRcvrZipnum())
                                    .build()
                    )
                    .map(JsonUtil.GSON::toJson).
                    orElse(null);
        } catch (NullPointerException e) {
            return JsonUtil.GSON.toJson(
                    Map.of("error", "CJ zip code processing failed", "message", e.getMessage())
            );
        }
    }
}
