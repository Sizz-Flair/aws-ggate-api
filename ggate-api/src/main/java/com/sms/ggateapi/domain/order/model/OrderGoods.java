package com.sms.ggateapi.domain.order.model;

import lombok.Builder;

@Builder
public record OrderGoods(
        String nameEng,
        String qtyUnit,
        String priceUsd,
        String standard,
        Integer qty
) {
}
