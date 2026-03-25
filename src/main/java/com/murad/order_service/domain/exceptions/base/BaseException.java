package com.murad.order_service.domain.exceptions.base;

import com.murad.order_service.domain.constants.ErrorCodes;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public abstract class BaseException extends RuntimeException{
    private final ErrorCodes errorCode;
    private final Object[] args;
}