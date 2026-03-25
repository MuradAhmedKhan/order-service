package com.murad.order_service.domain.constants;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCodes {
    USER_NOT_FOUND("USR_001", "user.not.found", HttpStatus.NOT_FOUND),
    INVALID_REQUEST("GEN_001", "invalid.request", HttpStatus.BAD_REQUEST),
    ACCESS_DENIED("SEC_001", "access.denied", HttpStatus.FORBIDDEN),
    INVALID_SERIALIZATION("SER_001", "invalid.serialization", HttpStatus.INTERNAL_SERVER_ERROR);

    private final String code;
    private final String messageKey;
    private final HttpStatus httpStatus;
}