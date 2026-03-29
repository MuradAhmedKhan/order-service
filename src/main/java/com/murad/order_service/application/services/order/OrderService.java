package com.murad.order_service.application.services.order;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.murad.order_service.application.services.outbox.SaveOutboxEventService;
import com.murad.order_service.application.usecases.order.OrderUseCase;
import com.murad.order_service.domain.annotations.TransactionalOptimisticRetry;
import com.murad.order_service.domain.dto.OrderRequest;
import com.murad.order_service.domain.dto.OrderResponse;
import com.murad.order_service.domain.entity.Order;
import com.murad.order_service.domain.extensions.JsonSerializerExtension;
import com.murad.order_service.domain.mapper.orderMapper.OrderMapper;
import com.murad.order_service.domain.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService implements OrderUseCase {

    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;
    private final SaveOutboxEventService saveOutboxEventService;
    private final JsonSerializerExtension jsonSerializerExtension;

    @Override
    @TransactionalOptimisticRetry
    public OrderResponse createOrder(OrderRequest request){
        Order order = orderMapper.toEntity(request);
        orderRepository.save(order);

        String payload = jsonSerializerExtension.toJson(order);
        saveOutboxEventService.saveOutboxEvents(order, payload);

        return orderMapper.toDto(order);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
    }
}