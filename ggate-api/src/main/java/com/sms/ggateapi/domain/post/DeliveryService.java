package com.sms.ggateapi.domain.post;

import org.springframework.lang.NonNull;

/**
 * Delivery service 클래스.
 * * <p>역할:
 * * <p>상속: PsiClass:Object
 * * @author YourName
 *
 * @since 2025 -09-07
 */
public interface DeliveryService {
    /**
     *
     * @return
     */
    String getDeliveryNum();

    /**
     *
     * @param data
     * @return
     */
    String getZipCode(@NonNull String ...data);
}
