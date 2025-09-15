package com.sms.ggateapi.domain.order.validation.core;

import java.util.ArrayList;
import java.util.List;

/**
 * ErrorMessage 클래스
 *
 * <p>설명:
 * <p>
 * 작성자: akfur
 * 작성일: 2025-09-13
 */
public class ErrorMessage {
    private static final int MAX_SIZE = 50;
    private final List<String> errorMessages;

    private ErrorMessage(List<String> errorMessages) {
        this.errorMessages = List.copyOf(errorMessages);
    }

    public static ErrorMessage of(List<String> errorMessages) {
        return new ErrorMessage(errorMessages);
    }

    public ErrorMessage add(final String msg) {
        List<String> newList = new ArrayList<>(this.errorMessages);
        newList.add(msg);
        return new ErrorMessage(newList);
    }

    public List<String> getErrorMessages() {
        return List.copyOf(errorMessages);
    }

    public int size() {
        return errorMessages.size();
    }

    public boolean isEmpty() {
        return errorMessages.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ErrorMessage)) return false;
        ErrorMessage that = (ErrorMessage) o;
        return errorMessages.equals(that.errorMessages);
    }

    @Override
    public int hashCode() {
        return errorMessages.hashCode();
    }
}
