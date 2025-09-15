package com.sms.ggateapi.validations.validator;

import java.util.ArrayList;
import java.util.List;

/**
 * VaildationResult 클래스
 *
 * <p>설명:
 * <p>
 * 작성자: akfur
 * 작성일: 2025-09-08
 *
 * @since 2025 -09-07
 */
public class ValidationResult {
    private final String hwbNo;
    private final List<String> errors = new ArrayList<>();

    public ValidationResult(String hwbNo) {
        this.hwbNo = hwbNo;
    }

    public static ValidationResult of(final String hwbNo) {
        return new ValidationResult(hwbNo);
    }

    public void addError(String message) {
        errors.add(message);
    }

    public void errorCopyOf(List<String> other) {
        errors.addAll(other);
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public List<String> getErrors() {
        return List.copyOf(errors);
    }
}
