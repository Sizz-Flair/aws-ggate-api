package com.sms.ggateapi.domain.order.controller;

import com.sms.ggateapi.domain.order.dto.OrderRequest;
import com.sms.ggateapi.domain.order.mapper.OrderMapper;
import com.sms.ggateapi.domain.order.service.OrderFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "주문 조회", description = "주문 ID로 주문 상세를 조회합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청")
    })
    @PostMapping("/order")
    public void order(@RequestBody OrderRequest orderRequest) {
        orderFacade.saveOrder(
                orderRequest.id(),
                orderRequest.key(),
                OrderMapper.toDomains(orderRequest.orders())
        );
    }
}
