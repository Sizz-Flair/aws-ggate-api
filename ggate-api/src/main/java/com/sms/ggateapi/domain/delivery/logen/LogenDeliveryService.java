package com.sms.ggateapi.domain.delivery.logen;

import com.sms.ggateapi.domain.delivery.DeliveryService;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

/**
 * LogenDeliveryService 클래스
 *
 * <p>설명:
 * <p>
 * 작성자: akfur
 * 작성일: 2025-09-08
 *
 * @since 2025 -09-07
 */
@Service("logenDeliveryService")
public class LogenDeliveryService implements DeliveryService {
    @Override
    public String getDeliveryNum() {
        return "";
    }

    @Override
    public String getZipCode(@NonNull String... data) {
        return "";
    }
}
