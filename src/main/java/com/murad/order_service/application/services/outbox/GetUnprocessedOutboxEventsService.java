package com.murad.order_service.application.services.outbox;

import java.util.List;

import org.springframework.data.domain.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.murad.order_service.domain.constants.OutboxStatus;
import com.murad.order_service.domain.entity.OutboxEvent;
import com.murad.order_service.domain.repository.OutboxRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GetUnprocessedOutboxEventsService {

    private final OutboxRepository outboxRepository;

    @Transactional(readOnly = true)
    public List<OutboxEvent> getUnprocessedEvents(){

        Pageable pageable = PageRequest.of(0, 10);

        return outboxRepository
            .findByEventStatus(OutboxStatus.PENDING, pageable)
            .getContent();
    }

}