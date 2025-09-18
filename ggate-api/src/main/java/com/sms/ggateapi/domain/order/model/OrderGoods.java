package com.sms.ggateapi.domain.order.model;

import lombok.Builder;

@Builder
public record OrderGoods(
        String nameEng,
        String nameExp,
        String priceUsd,
        String standard,
        Integer qty,
        String qtyUnit
) {
}
