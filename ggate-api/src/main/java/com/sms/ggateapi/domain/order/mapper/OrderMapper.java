package com.sms.ggateapi.domain.order.mapper;

import com.builder.TmAiHwbBuilder;
import com.example.jooq.generated.tables.pojos.TmAiHwbPojo;
import com.sms.ggateapi.domain.order.dto.OrderGoodsRequest;
import com.sms.ggateapi.domain.order.dto.OrderItemRequest;
import com.sms.ggateapi.domain.order.model.Order;
import com.sms.ggateapi.domain.order.model.OrderGoods;

import java.util.List;

/**
 * OrderMapper 클래스
 *
 * <p>설명:
 * <p>
 * 작성자: akfur
 * 작성일: 2025-09-09
 *
 * @since 2025 -09-07
 */
public final class OrderMapper {

    /**
     * DTO -> Domain
     */
    public static OrderGoods toDomain(final OrderGoodsRequest dto) {
        return OrderGoods.builder()
                .qty(dto.qty())
                .nameEng(dto.nameEng())
                .qtyUnit(dto.qtyUnit())
                .standard(dto.standard())
                .priceUsd(dto.priceUsd())
                .build();
    }

    /**
     * DTO -> Domain
     */
    public static Order toDomain(final OrderItemRequest dto) {
        List<OrderGoods> list = dto.goodsList()
                .stream()
                .map(OrderMapper::toDomain)
                .toList();

        return Order.builder()
                .hwbNo(dto.hwbNo())
                .deliveryCode(dto.deliveryCode())
                .agency(dto.agency())
                .volume(dto.volume())
                .qty(dto.qty())
                .orderNo(dto.orderNo())
                .weight(dto.weight())
                .tradeType(dto.tradeType())
                .commerceType(dto.commerceType())
                .useType(dto.useType())
                .hsCode(dto.hsCode())
                .consigneeCode(dto.consigneeCode())
                .consigneeNameImp(dto.consigneeNameImp())
                .consigneeAddressImp(dto.consigneeAddressImp())
                .consigneeTel(dto.consigneeTel())
                .siteHttpUrl(dto.siteHttpUrl())
                .orderDt(dto.orderDt())
                .goodsList(list)
                .build();
    }

    public static List<Order> toDomains(final List<OrderItemRequest> itemRequests) {
        return itemRequests.stream().map(OrderMapper::toDomain).toList();
    }

    public static List<TmAiHwbPojo> toJooqPojos(final List<Order> orders) {


    }

}
