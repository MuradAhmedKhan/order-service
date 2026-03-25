package com.murad.order_service.application.usecases.order;

import java.util.List;

import com.murad.order_service.domain.dto.OrderRequest;
import com.murad.order_service.domain.dto.OrderResponse;

public interface OrderUseCase {
    OrderResponse createOrder(OrderRequest request);
    List<OrderResponse> getAllOrders();
}