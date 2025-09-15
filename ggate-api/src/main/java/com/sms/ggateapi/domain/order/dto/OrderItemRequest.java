package com.sms.ggateapi.domain.order.dto;

import java.util.List;

/**
 * OrderItemRequest 클래스
 *
 * <p>설명:
 * <p>
 * 작성자: akfur
 * 작성일: 2025-09-09
 */
public record OrderItemRequest(
    String hwbNo,                // HWB number
    String deliveryCode,         // Carrier code
    String agency,               // Agency code
    String volume,               // Total volume
    String qty,                  // Quantity
    String orderNo,              // Order Number
    String weight,               // Gross weight
    String tradeType,            // Transaction type
    String commerceType,         // CommerceType type
    String useType,              // Classification of use
    String hsCode,               // Hash code
    String consigneeCode,        // Personal customs Code
    String consigneeNameImp,     // Consignee name
    String consigneeAddressImp,  // Consignee address
    String consigneeTel,         // Consignee number
    String siteHttpUrl,          // E-commerce site address
    String orderDt,              // Order date
    List<OrderGoodsRequest> goodsList
) {
}
