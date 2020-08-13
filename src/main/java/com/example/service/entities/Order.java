package com.example.service.entities;

import lombok.Data;

@Data
public class Order {

    private String customer;

    private Integer cost;

    public Order(String customer, Integer cost) {
        this.customer = customer;
        this.cost = cost;
    }

}
