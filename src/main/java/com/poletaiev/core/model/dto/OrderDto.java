package com.poletaiev.core.model.dto;

import lombok.*;

import java.util.Date;

/**
 * Created by andrey on 18.05.2021.
 */


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class OrderDto {
    private Double amount;
    private Date orderDate;
    private String customer;
    private String agent;
    private boolean approved;

    @Override
    public String toString() {
        return "OrderDto{" +
                ", amount=" + amount +
                ", orderDate=" + orderDate +
                ", customer='" + customer + '\'' +
                ", agent='" + agent + '\'' +
                ", approved=" + approved +
                '}';
    }
}