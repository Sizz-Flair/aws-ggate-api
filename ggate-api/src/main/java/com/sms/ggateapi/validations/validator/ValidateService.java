package com.sms.ggateapi.validations.validator;

import com.sms.ggateapi.domain.order.model.Order;
import com.sms.ggateapi.validations.ValidateFactory;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ValidateService 클래스
 *
 * <p>설명:
 * <p>
 * 작성자: akfur
 * 작성일: 2025-09-10
 */
@Service
@RequiredArgsConstructor
public class ValidateService {

    private final ValidateFactory validateFactory;

    public ValidationResult validateOne(@NonNull Order order) {
        return validateOrderAndAddr(order);
    }

    public List<ValidationResult> validate(final List<Order> order) {
        List<ValidationResult> results = order
                .stream()
                .map(this::validateOrderAndAddr)
                .toList();

        return results.stream()
                .filter(ValidationResult::hasErrors)
                .toList();
    }

    public void validateOrThrow(final List<Order> order) {
        List<ValidationResult> invalidResults = validate(order);
        if (!invalidResults.isEmpty()) {
            throw new IllegalArgumentException(invalidResults.toString());
        }
    }

    private ValidationResult validateOrderAndAddr(Order order) {

        ValidationResult validationResult = ValidationResult.of(order.hwbNo());

        validationResult.errorCopyOf(
                validateFactory.getOrder(order.agency()).valid(order)
        );

        validationResult.addError(
                validateFactory.getAddr(order.deliveryCode())
                        .valid(order.consigneeAddressImp(), order.deliveryCode())
        );

        return validationResult;
    }
}
