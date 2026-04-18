package com.nmquys.orderservice.controller;


import com.nmquys.orderservice.dto.OrderRequestDto;
import com.nmquys.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController
{
    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> placeOrder(@RequestBody OrderRequestDto orderRequestDto)
    {
        orderService.placeOrder(orderRequestDto);
        return ResponseEntity.ok("Order placed successfully");
    }

//    @GetMapping
//    public ResponseEntity<List<OrderResponseDto>> loadOrders()
//    {
//        return ResponseEntity.ok(orderService.getOrders();
//
//    }
}
