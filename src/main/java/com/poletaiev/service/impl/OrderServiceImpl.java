package com.poletaiev.service.impl;

import com.poletaiev.core.model.Order;
import com.poletaiev.core.model.OrderRepository;
import com.poletaiev.dao.OrderDao;
import com.poletaiev.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao;

    @Autowired
    public void setOrderRepository(final OrderRepository orderRepository) {
    }

    @Autowired
    public void setOrderDao(final OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public void createOrder(Order order) {
        orderDao.createOrder(order);
    }

    @Override
    public void updateOrder(Order order) {
        orderDao.updateOrder(order);
    }

    @Override
    public void deleteOrder(long orderId) {
        orderDao.deleteOrder(orderId);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderDao.getAllOrders();
    }

    @Override
    public Order getOrderById(long orderId) {
        return orderDao.getOrderById(orderId);
    }

//    @Override
//    public String getOrderByIdAsJson(long orderId) {
//        return JSON.toJson(getOrderById(orderId));
//    }
//
//    @Override
//    public String toJson(Order order) {
//        return JSON.toJson(order);
//    }
}
