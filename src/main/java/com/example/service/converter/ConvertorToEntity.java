package com.example.service.converter;

import com.example.service.dto.OrderDTO;
import com.example.service.entities.Order;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Convertor для конвертации DTO в Order
 *
 * @author JAM
 */
@Component
public class ConvertorToEntity implements Converter<OrderDTO, Order> {
    /**
     * @param orderDTO
     * @return order
     */
    @Override
    public Order convert(OrderDTO orderDTO) {
        return new Order(orderDTO.getCustomer(), orderDTO.getCost());
    }

}
