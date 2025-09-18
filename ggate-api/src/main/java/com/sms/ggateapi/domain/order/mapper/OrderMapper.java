package com.sms.ggateapi.domain.order.mapper;

import com.builder.TmAiHwbBuilder;
import com.example.jooq.generated.tables.pojos.TmAiHwbPojo;
import com.sms.ggateapi.domain.agent.model.Agent;
import com.sms.ggateapi.domain.order.dto.OrderGoodsRequest;
import com.sms.ggateapi.domain.order.dto.OrderItemRequest;
import com.sms.ggateapi.domain.order.model.Order;
import com.sms.ggateapi.domain.order.model.OrderGoods;
import com.sms.ggateapi.domain.order.model.enums.CargoType;

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
        List<OrderGoods> goodsList = dto.goodsList()
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
                .consigneeZip(dto.consigneeZip())
                .siteHttpUrl(dto.siteHttpUrl())
                .orderDt(dto.orderDt())
                .goodsList(goodsList)
                .build();
    }


    public static List<Order> toDomains(final List<OrderItemRequest> itemRequests) {
        return itemRequests.stream().map(OrderMapper::toDomain).toList();
    }

    public static List<TmAiHwbPojo> toJooqPojos(final List<Order> orders, Agent agent, String mappingNo) {
        return orders.stream()
                .map(v -> TmAiHwbBuilder
                        .Builder()
                        .hwbNo(v.hwbNo())
                        .deliveryCode(v.deliveryCode())
                        .agency(v.agency())
                        .agentId(agent.id())
                        .orderNo(v.orderNo())
                        .cargoType(CargoType.IMPORT.getType())
                        .mappingNo(mappingNo)
                        .commercetype(v.commerceType())
                        .agency(v.agency())
                        .shipperTel(agent.agentTel())
                        .shipperAddressImp(agent.agentAddress())
                        .shipperZip(agent.agentZip())
                        .shipperNameImp(agent.name())
                        .shipperNameEng(agent.name())
                        .shipperAddressEng(agent.agentAddress())
                        .consigneeAddressImp(v.consigneeAddressImp())
                        .consigneeCode(v.consigneeCode())
                        .consigneeTel(v.consigneeTel())
                        .consigneeZip(v.consigneeZip())
                        .consigneeNameImp(v.consigneeNameImp())
                        .consigneeTel(v.consigneeTel())
                        .consigneeZip(v.consigneeZip())
                        .siteHttpUrl(v.siteHttpUrl())
                        .build())
                .toList();
    }
}
