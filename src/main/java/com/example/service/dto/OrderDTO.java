package com.example.service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO для передачи объекта в UI
 *
 * customer - String, имя покупателя
 * cost     - Integer, стоимость заказа
 * @author JAM
 */
@Data
@NoArgsConstructor
public class OrderDTO {
    private String customer;
    private Integer cost;

    public OrderDTO(String customer, Integer cost) {
        this.customer = customer;
        this.cost = cost;
    }

}
