package com.nmquys.orderservice.service;


import com.nmquys.orderservice.dto.OrderRequestDto;
import com.nmquys.orderservice.model.Order;
import com.nmquys.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequestDto orderRequestDto)
    {
        //map OrderRquest to Order object
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setPrice(orderRequestDto.price());
        order.setQuantity(orderRequestDto.quantity());
        order.setSkuCode(orderRequestDto.SkuCode());


        //save order to OrderRepo
        orderRepository.save(order);
    }
}
