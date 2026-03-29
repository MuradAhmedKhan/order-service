package com.murad.order_service.domain.mapper.outboxMapper;

import com.murad.order_service.domain.entity.Order;
import com.murad.order_service.domain.entity.OutboxEvent;
import java.time.Instant;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-29T13:03:08-0400",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.45.0.v20260224-0835, environment: Java 26 (Oracle Corporation)"
)
@Component
public class OutboxEventMapperImpl implements OutboxEventMapper {

    @Override
    public OutboxEvent toEntity(Order order, String payload) {
        if ( order == null && payload == null ) {
            return null;
        }

        OutboxEvent outboxEvent = new OutboxEvent();

        if ( order != null ) {
            if ( order.getId() != null ) {
                outboxEvent.setAggregateId( String.valueOf( order.getId() ) );
            }
            if ( order.getCreatedAt() != null ) {
                outboxEvent.setCreatedAt( order.getCreatedAt() );
            }
            else {
                outboxEvent.setCreatedAt( Instant.now() );
            }
        }
        outboxEvent.setPayload( payload );
        outboxEvent.setAggregateType( "Order" );
        outboxEvent.setEventStatus( "PENDING" );

        return outboxEvent;
    }
}
