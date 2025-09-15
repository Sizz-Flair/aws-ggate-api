package com.sms.ggateapi.domain.order.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record OrderRequest(
    List<OrderItemRequest> orders
) {
}
