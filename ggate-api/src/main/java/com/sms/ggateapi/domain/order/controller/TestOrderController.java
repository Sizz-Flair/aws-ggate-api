package com.sms.ggateapi.domain.order.controller;

import com.sms.ggateapi.domain.order.dto.OrderRequest;
import com.sms.ggateapi.domain.order.dto.TestOrderRequest;
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

@RestController
@RequestMapping("/api/v2/g-gate")
@RequiredArgsConstructor
public class TestOrderController {

    private final OrderFacade orderFacade;

    @Operation(summary = "주문 조회", description = "주문 ID로 주문 상세를 조회합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청")
    })
    @PostMapping("/{bound}/hwb/insert")
    public void order(@RequestBody TestOrderRequest testOrderRequest) {
        orderFacade.testSaveOrder(testOrderRequest);
    }
}
