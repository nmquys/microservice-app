package com.nmquys.orderservice.service;


import com.nmquys.orderservice.client.InventoryClient;
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
    private final InventoryClient inventoryClient;

    public void placeOrder(OrderRequestDto orderRequestDto)
    {
        var isProductInStock =
                inventoryClient.isInStock(orderRequestDto.skuCode(), orderRequestDto.quantity());

        if(isProductInStock)
        {
            //map OrderRquest to Order object
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setPrice(orderRequestDto.price());
            order.setQuantity(orderRequestDto.quantity());
            order.setSkuCode(orderRequestDto.skuCode());

            //save order to OrderRepo
            orderRepository.save(order);
        }
        else {
            throw new RuntimeException("product woth SkuCode" +
                    orderRequestDto.skuCode() +
                    "is not in stock");
        }
    }
}
