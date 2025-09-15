package com.sms.ggateapi.domain.order.validation.tms;

import com.sms.ggateapi.domain.order.model.Order;
import com.sms.ggateapi.domain.order.validation.core.AbstractOrderValidator;
import com.sms.ggateapi.domain.order.validation.core.OrderValidationService;
import com.sms.ggateapi.validations.validator.ValidatorRule;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("tms")
public class TmsOrderValidator extends AbstractOrderValidator implements OrderValidationService {

    ValidatorRule<String> tmsOrderRule = ValidatorRule.ofOne(
            v -> true,
            "Order No is invalid"
    );

    @Override
    public List<String> valid(Order order) {
        List<String> errorMessage = new ArrayList<>();

        setErrorMessage(this.hwbNoRule, order.hwbNo(), errorMessage);
        setErrorMessage(this.tmsOrderRule, order.orderNo(), errorMessage);

        return errorMessage;
    }

}
