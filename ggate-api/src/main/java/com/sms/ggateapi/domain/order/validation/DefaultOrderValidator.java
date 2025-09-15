package com.sms.ggateapi.domain.order.validation;

import com.sms.ggateapi.domain.order.model.Order;
import com.sms.ggateapi.domain.order.validation.core.AbstractOrderValidator;
import com.sms.ggateapi.domain.order.validation.core.OrderValidationService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("default")
public class DefaultOrderValidator extends AbstractOrderValidator implements OrderValidationService {

    @Override
    public List<String> valid(Order order) {
        List<String> errorMessage = new ArrayList<>();

        setErrorMessage(this.hwbNoRule, order.hwbNo(), errorMessage);
        setErrorMessage(this.orderNoRule, order.orderNo(), errorMessage);

        return errorMessage;
    }
}
