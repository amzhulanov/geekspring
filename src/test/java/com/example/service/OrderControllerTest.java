package com.example.service;

import com.example.service.controllers.OrderController;
import com.example.service.converter.ConvertorToDTO;
import com.example.service.converter.ConvertorToEntity;
import com.example.service.dto.OrderDTO;
import com.example.service.entities.Order;
import com.example.service.services.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

class OrderControllerTest {
    private static final String USER = "user1";
    private static final Integer COST = 12;
    private OrderController orderController;
    private final List<Order> orderList = new ArrayList<>();
    private final List<OrderDTO> orderDTOList = new ArrayList<>();
    private final OrderDTO orderDTO = new OrderDTO(USER, COST);
    private final Order order = new Order(USER, COST);

    @BeforeEach
    public void setUp() throws Exception {
        orderList.add(order);
        orderDTOList.add(orderDTO);
        ConvertorToEntity mockConvertorToEntity = mock(ConvertorToEntity.class);
        ConvertorToDTO mockConvertorToDTO = mock(ConvertorToDTO.class);
        OrderService mockService = mock(OrderService.class);
        orderController = new OrderController(mockService);
        when(mockService.findOrderListByCustomer(orderDTO)).thenReturn(orderDTOList);
        when(mockConvertorToEntity.convert(orderDTO)).thenReturn(order);
        when(mockConvertorToDTO.convert(orderList)).thenReturn(orderDTOList);
    }

    @Test
    @DisplayName("Test mockito case for controller")
    void getUserTest() {
        ResponseEntity<String> json = orderController.getOrderList(orderDTO);
        assertThat(json != null);
        assertThat(json.toString().contains(USER));
    }

}