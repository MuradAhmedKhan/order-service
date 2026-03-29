package com.murad.order_service.domain.mapper.orderMapper;

import com.murad.order_service.domain.dto.OrderRequest;
import com.murad.order_service.domain.dto.OrderResponse;
import com.murad.order_service.domain.entity.Order;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-29T13:03:08-0400",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.45.0.v20260224-0835, environment: Java 26 (Oracle Corporation)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public Order toEntity(OrderRequest request) {
        if ( request == null ) {
            return null;
        }

        Order.OrderBuilder order = Order.builder();

        order.userId( request.userId() );
        order.totalAmount( request.totalAmount() );

        order.status( "PENDING" );
        order.createdAt( Instant.now() );
        order.orderNumber( UUID.randomUUID() );

        return order.build();
    }

    @Override
    public OrderResponse toDto(Order order) {
        if ( order == null ) {
            return null;
        }

        Long id = null;
        String orderNumber = null;
        Long userId = null;
        BigDecimal totalAmount = null;
        String status = null;
        Instant createdAt = null;

        id = order.getId();
        if ( order.getOrderNumber() != null ) {
            orderNumber = order.getOrderNumber().toString();
        }
        userId = order.getUserId();
        totalAmount = order.getTotalAmount();
        status = order.getStatus();
        createdAt = order.getCreatedAt();

        Instant updatedAt = Instant.now();

        OrderResponse orderResponse = new OrderResponse( id, orderNumber, userId, totalAmount, status, createdAt, updatedAt );

        return orderResponse;
    }
}
