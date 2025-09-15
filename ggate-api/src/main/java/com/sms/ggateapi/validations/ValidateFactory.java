package com.sms.ggateapi.validations;

import com.sms.ggateapi.domain.order.validation.core.OrderValidationService;
import com.sms.ggateapi.validations.validator.addr.AddrValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

/**
 * ValidateFactory 클래스
 *
 * <p>설명:
 * <p>
 * 작성자: akfur
 * 작성일: 2025-09-09
 */
@Component
@RequiredArgsConstructor
public class ValidateFactory {

    enum FactoryName {
        DEFAULT, TMS;
    }

    private final Map<String, OrderValidationService> orderValidateFactory;
    private final Map<String, AddrValidationService> addrValidateFactory;

    public AddrValidationService getAddr(final String key) {
        return getService(addrValidateFactory, key, FactoryName.DEFAULT.name());
    }

    public OrderValidationService getOrder(final String key) {
        return getService(orderValidateFactory, key, FactoryName.DEFAULT.name());
    }

    private <T> T getService(Map<String, T> factory, String key, String defaultKey) {
        return Optional
                .ofNullable(factory.getOrDefault(key, factory.get(defaultKey)))
                .orElseThrow(() -> new IllegalArgumentException("No validator for key: " + key));
    }
}
