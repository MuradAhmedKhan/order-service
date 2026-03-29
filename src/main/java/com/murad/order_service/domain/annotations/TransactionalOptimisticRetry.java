package com.murad.order_service.domain.annotations;

import java.lang.annotation.*;

import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.retry.annotation.*;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Transactional(propagation = Propagation.REQUIRES_NEW)
@Retryable(
    retryFor = {
        OptimisticLockingFailureException.class,
        ObjectOptimisticLockingFailureException.class
    },
    maxAttempts = 3,
    backoff = @Backoff(delay = 300)
)
public @interface TransactionalOptimisticRetry {}