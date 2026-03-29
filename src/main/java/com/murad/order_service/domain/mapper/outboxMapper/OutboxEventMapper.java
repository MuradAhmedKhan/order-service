package com.murad.order_service.domain.mapper.outboxMapper;

import java.time.Instant;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.murad.order_service.domain.entity.Order;
import com.murad.order_service.domain.entity.OutboxEvent;

@Mapper(componentModel = "spring", imports = {
    Instant.class
})
public interface OutboxEventMapper {

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "aggregateType", constant = "Order"),
        @Mapping(target = "aggregateId", source = "order.id"),
        @Mapping(target = "eventStatus", constant = "PENDING"),
        @Mapping(target = "payload", source = "payload"),
        @Mapping(target = "createdAt", defaultExpression = "java(Instant.now())"),
        @Mapping(target = "version", ignore = true)
    })
    OutboxEvent toEntity(Order order, String payload);
}