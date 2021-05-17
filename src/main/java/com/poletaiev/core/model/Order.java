package com.poletaiev.core.model;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Entity;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@javax.persistence.Entity
@Table(name = "ORDERS")
public class Order {
    @SerializedName("order_number")
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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