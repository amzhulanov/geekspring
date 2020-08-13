package com.example.service.converter;

import com.example.service.dto.OrderDTO;
import com.example.service.entities.Order;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Convertor для конвертации списка Order в список DTO
 *
 * @author JAM
 */
@Component
public class ConvertorToDTO implements Converter<List<Order>, List<OrderDTO>> {

    @Override
    public List<OrderDTO> convert(List<Order> orders) {
        List<OrderDTO> orderDTOList=new ArrayList<>();
        for (Order item:orders) {
            orderDTOList.add(new OrderDTO(item.getCustomer(), item.getCost()));
        }
        return orderDTOList;
    }
}
