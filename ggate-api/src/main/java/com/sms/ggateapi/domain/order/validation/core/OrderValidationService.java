package com.sms.ggateapi.domain.order.validation.core;

import com.sms.ggateapi.domain.order.model.Order;

import java.util.List;

public interface OrderValidationService {
    List<String> valid(Order order);
}
