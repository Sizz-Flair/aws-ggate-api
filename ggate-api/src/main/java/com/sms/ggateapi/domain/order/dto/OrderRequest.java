package com.sms.ggateapi.domain.order.dto;

import java.util.List;

public record OrderRequest(
    String id,
    String key,
    List<OrderItemRequest> orders
) {
}
