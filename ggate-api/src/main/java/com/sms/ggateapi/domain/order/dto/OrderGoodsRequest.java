package com.sms.ggateapi.domain.order.dto;

/**
 * OrderGoodsRequest 클래스
 *
 * <p>설명:
 * <p>
 * 작성자: akfur
 * 작성일: 2025-09-09
 */
public record OrderGoodsRequest(
    String nameEng,
    String qtyUnit,
    String priceUsd,
    String standard,
    Integer qty
) {
}
