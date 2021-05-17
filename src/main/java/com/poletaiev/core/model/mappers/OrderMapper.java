package com.poletaiev.core.model.mappers;

import com.poletaiev.core.model.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class OrderMapper implements RowMapper{
    public static final String ID_MAPPED_COLUMN_NAME = "ORD_NUM";
    public static final String ORDER_AMOUNT_MAPPED_COLUMN_NAME = "ORD_AMOUNT";
    public static final String ORDER_DATE_MAPPED_COLUMN_NAME = "ORD_DATE";
    public static final String CUSTOMER_CODE_MAPPED_COLUMN_NAME = "CUST_CODE";
    public static final String AGENT_CODE_MAPPED_COLUMN_NAME = "AGENT_CODE";
    public static final String IS_APPROVED_MAPPED_COLUMN_NAME = "IS_APPROVED";

    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        long id_ = rs.getLong(ID_MAPPED_COLUMN_NAME);
        double amount_ = rs.getDouble(ORDER_AMOUNT_MAPPED_COLUMN_NAME);
        Date date_ = rs.getDate(ORDER_DATE_MAPPED_COLUMN_NAME);
        String customerCode_ = rs.getString(CUSTOMER_CODE_MAPPED_COLUMN_NAME);
        String agentCode_ = rs.getString(AGENT_CODE_MAPPED_COLUMN_NAME);
        boolean isApproved_ = rs.getBoolean(IS_APPROVED_MAPPED_COLUMN_NAME);

        return new Order(id_, amount_, date_, customerCode_, agentCode_, isApproved_);
    }
}