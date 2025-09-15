package com.sms.ggateapi.domain.order.exceptions;

import java.util.ArrayList;
import java.util.List;

/**
 * OrderSaveException 클래스
 *
 * <p>설명:
 * <p>
 * 작성자: akfur
 * 작성일: 2025-09-13
 */
public class OrderSaveException extends RuntimeException {
    private final List<String> errors;

    public OrderSaveException(List<String> errors) {
        this.errors = new ArrayList<>(errors);
    }

    public List<String> getErrors() {
        return new ArrayList<>(errors);
    }
}
