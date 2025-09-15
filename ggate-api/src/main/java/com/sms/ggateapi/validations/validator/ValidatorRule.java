package com.sms.ggateapi.validations.validator;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class ValidatorRule<T> {

    private BiPredicate<T, T> biPredicate;
    private Predicate<T> predicate;
    private final String errorMessage;

    public ValidatorRule(Predicate<T> predicate, String errorMessage) {
        this.predicate = predicate;
        this.errorMessage = errorMessage;
    }
    public ValidatorRule(BiPredicate<T, T> biPredicate, String errorMessage) {
        this.biPredicate = biPredicate;
        this.errorMessage = errorMessage;
    }

    public static <T> ValidatorRule<T> ofOne(Predicate<T> predicate, String errorMessage) {
        return new ValidatorRule<>(predicate, errorMessage);
    }

    public static <T> ValidatorRule<T> ofTwo(BiPredicate<T, T> biPredicate, String errorMessage) {
        return new ValidatorRule<>(biPredicate, errorMessage);
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public boolean valid(T t) {
        return predicate.test(t);
    }

    public boolean valid(T t, T r) {
        return biPredicate.test(t, r);
    }
}
