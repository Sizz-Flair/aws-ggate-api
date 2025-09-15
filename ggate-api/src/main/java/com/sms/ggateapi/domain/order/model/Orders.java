package com.sms.ggateapi.domain.order.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Orders 클래스
 *
 * <p>설명:
 * <p>
 * 작성자: akfur
 * 작성일: 2025-09-14
 */
public class Orders {
    private final List<Order> orders;

    private Orders(List<Order> orders) {
        this.orders = List.copyOf(orders);
    }

    public Orders of(List<Order> orders) {
        return new Orders(orders);
    }

    public Orders add(Order order) {
        List<Order> newOrders = new ArrayList<>(orders);
        newOrders.add(order);
        return new Orders(newOrders);
    }

    public int size() {
        return orders.size();
    }

    public boolean isEmpty() { return orders.isEmpty(); }

    public boolean contains(Order order) { return orders.contains(order); }
}
