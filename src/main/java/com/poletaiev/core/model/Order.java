package com.poletaiev.core.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {
    @SerializedName("order_number")
    private long id;
    @SerializedName("order_amount")
    private Double amount;
    @SerializedName("order_date")
    private Date orderDate;
    @SerializedName("customer_code")
    private String customer;
    @SerializedName("agent_code")
    private String agent;
    @SerializedName("is_approved")
    private boolean approved;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", amount=" + amount +
                ", orderDate=" + orderDate +
                ", customer='" + customer + '\'' +
                ", agent='" + agent + '\'' +
                ", approved=" + approved +
                '}';
    }
}