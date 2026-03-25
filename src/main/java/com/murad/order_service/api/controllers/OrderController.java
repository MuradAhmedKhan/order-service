package com.murad.order_service.api.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.murad.order_service.application.usecases.order.OrderUseCase;
import com.murad.order_service.domain.dto.OrderRequest;
import com.murad.order_service.domain.dto.OrderResponse;





@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {
    
    private final OrderUseCase orderUseCase;

    @PostMapping
    public ResponseEntity<Void> createOrder(@Valid @RequestBody OrderRequest request) {
        orderUseCase.createOrder(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @GetMapping
    public ResponseEntity<List<OrderResponse>> getAllOrders(){
        return ResponseEntity.ok(orderUseCase.getAllOrders());
    }
}