package com.murad.order_service.domain.mapper.orderMapper;

import java.time.Instant;
import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.murad.order_service.domain.dto.OrderRequest;
import com.murad.order_service.domain.dto.OrderResponse;
import com.murad.order_service.domain.entity.Order;

@Mapper(componentModel = "spring", imports = {
    Instant.class,
    UUID.class
})
public interface OrderMapper {
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "status", constant = "PENDING")
    @Mapping(target = "createdAt", expression = "java(Instant.now())")
    @Mapping(target = "orderNumber", expression = "java(UUID.randomUUID())")
    Order toEntity(OrderRequest request);

    @Mapping(target = "updatedAt", expression = "java(Instant.now())")
    OrderResponse toDto(Order order);
}