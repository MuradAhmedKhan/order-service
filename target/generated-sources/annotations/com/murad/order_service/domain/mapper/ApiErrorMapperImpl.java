package com.murad.order_service.domain.mapper;

import com.murad.order_service.domain.errors.ApiError;
import com.murad.order_service.domain.mapper.errorMapper.ApiErrorMapper;

import java.time.Instant;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-24T18:59:20-0400",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.45.0.v20260224-0835, environment: Java 26 (Oracle Corporation)"
)
@Component
public class ApiErrorMapperImpl implements ApiErrorMapper {

    @Override
    public ApiError toDto(String errorCode, String errorMessage, String path, String requestId) {
        if ( errorCode == null && errorMessage == null && path == null ) {
            return null;
        }

        String code = null;
        code = errorCode;
        String message = null;
        message = errorMessage;
        String path1 = null;
        path1 = path;

        String requestId1 = requestId;
        Instant timeStamp = Instant.now();

        ApiError apiError = new ApiError( code, message, timeStamp, path1, requestId1 );

        return apiError;
    }
}
