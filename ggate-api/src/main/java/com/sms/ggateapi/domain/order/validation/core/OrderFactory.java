package com.sms.ggateapi.domain.order.validation.core;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * OrderFactory 클래스
 *
 * <p>설명:
 * <p>
 * 작성자: akfur
 * 작성일: 2025-09-13
 */
@Component
@RequiredArgsConstructor
public class OrderFactory {

    enum OrderType {
        TMS, DEFAULT;
    }

    private final Map<String, OrderValidationService> orderValidationServices;

    OrderValidationService getValidation(final String key) {
        return orderValidationServices
                .getOrDefault(key, orderValidationServices.get(OrderType.DEFAULT.name()));
    }
}
