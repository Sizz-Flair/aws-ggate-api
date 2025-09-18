package com.sms.ggateapi.domain.order.model;

import com.sms.ggateapi.domain.order.dto.OrderDt;
import lombok.Builder;

import java.util.List;

@Builder
public record Order(
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
        String consigneeZip,
        String siteHttpUrl,          // E-commerce site address
        OrderDt orderDt,              // Order date
        String shipperNameExp,
        String shipperTel,
        String shipperZip,
        String shipperAddressExp,
        String shipperPlace,
        String passAddress,
        List<OrderGoods> goodsList             // Product information list
) {
}
