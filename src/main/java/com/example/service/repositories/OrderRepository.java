package com.example.service.repositories;

import com.example.service.converter.ConvertorToEntity;
import com.example.service.dto.OrderDTO;
import com.example.service.entities.Order;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Репозиторий получает DTO и конвертирует его в Entity
 * Обращается к источнику данных и выгружает список нужных Entity
 * Возвращает список Entity
 *
 * @author JAM
 */
@Component
public class OrderRepository implements InitializingBean {

    private List<Order> orderList;
    private final ConvertorToEntity convertorToEntity;

    @Autowired
    public OrderRepository(ConvertorToEntity convertorToEntity) {
        this.convertorToEntity = convertorToEntity;
    }

    @Override
    public void afterPropertiesSet() {
        orderList = new ArrayList<>();
        orderList.add(new Order("user1", 12));
    }

    /**
     * @param orderDTO
     * @return List<order>
     */
    public List<Order> findByCustomer(OrderDTO orderDTO) {
        Order order = convertorToEntity.convert(orderDTO);
        List<Order> getOrderList = new ArrayList<>();
        for (Order item : orderList) {
            if (item.getCustomer().equals(order.getCustomer())) {
                getOrderList.add(item);
            }

        }
        return getOrderList;
    }

}
