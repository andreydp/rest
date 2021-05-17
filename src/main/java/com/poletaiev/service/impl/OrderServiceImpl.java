package com.poletaiev.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializer;
import com.poletaiev.Constants;
import com.poletaiev.core.model.Order;
import com.poletaiev.core.model.OrderRepository;
import com.poletaiev.dao.OrderDao;
import com.poletaiev.service.OrderService;
import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    private final Gson JSON;
    private  OrderRepository orderRepository;
    private OrderDao orderDao;


    {
        GsonBuilder gsonBuilder = new GsonBuilder().setPrettyPrinting().setDateFormat(Constants.ORDER_DATE_FORMAT_STRING);
        gsonBuilder.registerTypeAdapter(Double.class, (JsonSerializer<Double>) (src, typeOfSrc, context) ->
                new JsonPrimitive(Double.parseDouble(String.valueOf(src))));
        JSON = gsonBuilder.create();
    }

    @Autowired
    public void setOrderRepository(final OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
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
    public void deleteOrder(Order order) {
        orderDao.deleteOrder(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderDao.getAllOrders();
    }

    @Override
    public Order getOrderById(long orderId) {
        return orderDao.getOrderById(orderId);
    }

    @Override
    public String getOrderByIdAsJson(long orderId) {
        return JSON.toJson(getOrderById(orderId));
    }

    @Override
    public String toJson(Order order) {
        return JSON.toJson(order);
    }
}
