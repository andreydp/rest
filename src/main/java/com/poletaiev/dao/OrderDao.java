package com.poletaiev.dao;

import com.poletaiev.core.model.Order;

import javax.sql.DataSource;
import java.util.List;

public interface OrderDao {

    void createOrder(Order order);

    void updateOrder(Order order);

    Order getOrderById(long orderId);

    List<Order> getAllOrders();

    void deleteOrder(long orderId);

    void setDataSource(DataSource dataSource);
}
