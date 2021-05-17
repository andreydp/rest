package com.poletaiev.dao.impl;

import com.poletaiev.core.model.Order;
import com.poletaiev.core.model.mappers.OrderMapper;
import com.poletaiev.dao.OrderDao;
import org.apache.log4j.Logger;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class OrderDaoJdbcImpl implements OrderDao {
    private JdbcTemplate jdbcTemplate;
    private static final Logger orderDaoLogger = Logger.getLogger(OrderDaoJdbcImpl.class);

    @Override
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
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
        String SQL = "EXEC getOrderById @id = ?";
        try {
            return (Order) jdbcTemplate.queryForObject(SQL, new Object[]{orderId}, new OrderMapper());
        } catch (EmptyResultDataAccessException e) {
            orderDaoLogger.warn("Empty result returned for orderId='" + orderId + "'");
            return null;
        }
    }

    @Override
    public List<Order> getAllOrders() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteOrder(Order order) {
        throw new UnsupportedOperationException();
    }
}
