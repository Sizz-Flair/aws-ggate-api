package com.sms.ggateapi.domain.order.validation.core;

import com.sms.ggateapi.validations.validator.ValidatorRule;

import java.util.List;
import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public abstract class AbstractOrderValidator {
    protected Predicate<String> isNotNullAndNotEmpty =
            v -> Objects.nonNull(v) && !v.isEmpty();

    protected BiPredicate<String, String> isBiNotNullAndNotEmpty =
            (v, r) -> Objects.nonNull(v) && !v.isEmpty();

    protected Predicate<String> isValidDeliveryCode =
            v -> Pattern.compile("CJ|LOGEN").matcher(v).matches();

    protected Predicate<String> isValidUseType =
            v -> Pattern.compile("1|2").matcher(v).matches();

    protected BiPredicate<String, String> isValidTradeType = (useType, tradeType) -> {
                boolean isType1Valid = useType.equals("1") && (tradeType.equals("A") || tradeType.equals("B"));
                boolean isType2Valid = useType.equals("2") && (tradeType.equals("E") || tradeType.equals("F"));
                return isType1Valid || isType2Valid;
    };

    protected Predicate<String> isValidHsCode =
            v -> Pattern.compile("\\d+").matcher(v).matches();

    protected ValidatorRule<String> hwbNoRule = ValidatorRule.ofOne(
            isNotNullAndNotEmpty,
        "HWB No is invalid"
    );

    protected ValidatorRule<String> orderNoRule = ValidatorRule.ofOne(
            isNotNullAndNotEmpty,
            "Order No is invalid"
    );

    protected ValidatorRule<String> orderDtRule = ValidatorRule.ofOne(
            isNotNullAndNotEmpty,
            "Order Date is invalid"
    );

    protected ValidatorRule<String> deliveryCodeRule = ValidatorRule.ofOne(
            isNotNullAndNotEmpty
                    .and(isValidDeliveryCode),
            "Order Date is invalid"
    );

    protected ValidatorRule<String> useTypeRule = ValidatorRule.ofOne(
            isNotNullAndNotEmpty
                    .and(isValidUseType),
            "Order Date is invalid"
    );

    protected ValidatorRule<String> tradeTypeRule = ValidatorRule.ofTwo(
            isBiNotNullAndNotEmpty
                    .and(isValidTradeType),
            "Order Date is invalid"
    );

    ValidatorRule<String> hsCodeRule = ValidatorRule.ofOne(
            isNotNullAndNotEmpty
                    .and(isValidHsCode),
            "Order Date is invalid"
    );

    protected ValidatorRule<String> deliveryAddressRule = ValidatorRule.ofOne(
            isNotNullAndNotEmpty
                    .and(isValidHsCode),
            "Order Date is invalid"
    );

    protected <T> void setErrorMessage(ValidatorRule<T> validatorRule, T value, List<String> errorMessages) {
        if(!validatorRule.valid(value)){
            errorMessages.add(validatorRule.getErrorMessage());
        }
    }
}


