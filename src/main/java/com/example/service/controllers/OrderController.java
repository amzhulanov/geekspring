package com.example.service.controllers;

import com.example.service.dto.OrderDTO;
import com.example.service.services.OrderService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер принимает json и преобразует его в DTO
 * Запрашивает у сервиса данные по DTO
 * Получает результат в качестве списка DTO
 * Конвертирует список с результатами в Json и возвращает в UI
 *
 * @author JAM
 */
@Controller
@RequestMapping("/service")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * @param orderDTO
     * @return ResponseEntity<String>
     */
    @GetMapping
    public ResponseEntity<String> getOrderList(@RequestBody OrderDTO orderDTO) {
        List<OrderDTO> orderDTOList = orderService.findOrderListByCustomer(orderDTO);
        if (orderDTOList.size() > 0) {
            return new ResponseEntity<>(new Gson().toJson(orderDTOList), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Order not found", HttpStatus.NOT_FOUND);
        }
    }

}
