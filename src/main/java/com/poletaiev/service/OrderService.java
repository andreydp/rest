package com.poletaiev.service;

import com.poletaiev.core.model.Order;

import java.util.List;

public interface OrderService {
    void createOrder(Order order);

    List<Order> getAllOrders();

    Order getOrderById(long orderId);

    void updateOrder(Order order);

    void deleteOrder(Order order);

    String getOrderByIdAsJson(long orderId);

    String toJson(Order order);
}