package com.poletaiev.core.model;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.persistence.Column;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Order {
    @SerializedName("order_number")
    @javax.persistence.Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ORD_NUM", nullable=false, updatable=false)
    private Long id;
    @SerializedName("order_amount")
    @Column(name = "ORD_AMOUNT")
    private Double amount;
    @SerializedName("order_date")
    @Column(name = "ORD_DATE")
    private Date orderDate;
    @Column(name = "CUST_CODE")
    @SerializedName("customer_code")
    private String customer;
    @SerializedName("agent_code")
    @Column(name = "AGENT_CODE")
    private String agent;
    @SerializedName("is_approved")
    @Column(name = "IS_APPROVED")
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