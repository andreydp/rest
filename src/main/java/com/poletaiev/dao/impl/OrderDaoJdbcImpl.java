package com.poletaiev.dao.impl;

import com.poletaiev.core.model.APIException;
import com.poletaiev.core.model.Order;
import com.poletaiev.core.model.OrderRepository;
import com.poletaiev.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.util.List;

import static com.poletaiev.Constants.ERR_CODE_ORDER_NOT_FOUND;

public class OrderDaoJdbcImpl implements OrderDao {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    public void setOrderRepository(final OrderRepository orderRepository) {
    }

    @Autowired
    @Override
    public void setDataSource(DataSource dataSource) {
    }

    @Override
    public void createOrder(Order order) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateOrder(Order order) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Order getOrderById(long orderId) {
        return orderRepository.findById(orderId).orElseThrow(() -> new APIException(ERR_CODE_ORDER_NOT_FOUND, "Order with id='" + orderId + "' not found"));
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public void deleteOrder(long orderId) {
        orderRepository.deleteById(orderId);
    }
}
