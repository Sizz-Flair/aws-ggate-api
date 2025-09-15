package com.sms.ggateapi.domain.order.service;

import com.sms.ggateapi.domain.order.model.Order;
import com.sms.ggateapi.validations.validator.ValidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ValidateFacaed 클래스
 *
 * <p>설명:
 * <p>
 * 작성자: akfur
 * 작성일: 2025-09-08
 */
@Service
@RequiredArgsConstructor
public class OrderFacade {
    private final OrderService orderService;
    private final ValidateService validateService;

    public Order saveOrder(List<Order> orders) {
        validateService.validateOrThrow(orders);

        orderService.saveALl();


    }
}
