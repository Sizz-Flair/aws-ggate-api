package com.sms.ggateapi.domain.order.controller;

import com.sms.ggateapi.domain.order.dto.OrderRequest;
import com.sms.ggateapi.domain.order.mapper.OrderMapper;
import com.sms.ggateapi.domain.order.service.OrderFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AirOrderController 클래스
 *
 * <p>설명:
 * <p>
 * 작성자: akfur
 * 작성일: 2025-09-09
 */

@RestController
@RequestMapping("/air")
@RequiredArgsConstructor
public class AirOrderController {

    private final OrderFacade orderFacade;

    @PostMapping("/order")
    public void order(@RequestBody OrderRequest orderRequest) {
        orderFacade.saveOrder(OrderMapper.toDomains(orderRequest.orders()));
    }
}
