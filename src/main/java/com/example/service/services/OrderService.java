package com.example.service.services;

import com.example.service.converter.ConvertorToDTO;
import com.example.service.dto.OrderDTO;
import com.example.service.repositories.OrderRepository;
import com.example.service.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *Получает запрос от контроллера
 * Обращается к репозиторию за необходимыми данными
 * Конвертирует полученные данные в DTO для контроллера
 * Отправляет список DTO контроллеру
 *
 * @author JAM
 */
@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ConvertorToDTO convertorToDTO;

    @Autowired
    public OrderService(OrderRepository orderRepository, ConvertorToDTO convertorToDTO) {
        this.orderRepository = orderRepository;
        this.convertorToDTO = convertorToDTO;
    }

    /**
     *
     * @param orderDTO
     * @return List<OrderDTO>
     */
    public List<OrderDTO> findOrderListByCustomer(OrderDTO orderDTO)  {
        List<Order> orderList=orderRepository.findByCustomer(orderDTO);
        return convertorToDTO.convert(orderList);
    }

}
