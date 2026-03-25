package com.murad.order_service.api.middleware;

import java.util.Locale;

import org.slf4j.MDC;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.murad.order_service.domain.constants.ErrorCodes;
import com.murad.order_service.domain.errors.ApiError;
import com.murad.order_service.domain.exceptions.base.BaseException;
import com.murad.order_service.domain.mapper.errorMapper.ApiErrorMapper;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final MessageSource messageSource;
    private final ApiErrorMapper apiErrorMapper;

    @ExceptionHandler({
        BaseException.class
    })
    public ResponseEntity<ApiError> handleSerialization(BaseException ex, HttpServletRequest request, Locale locale){
        ErrorCodes errorCode = ex.getErrorCode();

        String message = messageSource.getMessage(
            errorCode.getMessageKey(),
            ex.getArgs(),
            locale
        );

        return ResponseEntity
            .status(errorCode.getHttpStatus())
            .body(
                apiErrorMapper.toDto(
                    errorCode.getCode(),
                    message,
                    request.getRequestURI(),
                    MDC.get("requestId")
                )
            );
    }
}