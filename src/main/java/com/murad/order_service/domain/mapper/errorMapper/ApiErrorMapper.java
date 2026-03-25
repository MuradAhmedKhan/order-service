package com.murad.order_service.domain.mapper.errorMapper;

import java.time.Instant;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.murad.order_service.domain.errors.ApiError;

@Mapper(componentModel = "spring", imports = {Instant.class})
public interface ApiErrorMapper {

    @Mapping(target = "requestId", expression = "java(requestId)")
    @Mapping(target = "timeStamp", expression = "java(Instant.now())")
    @Mapping(target = "code", source = "errorCode")
    @Mapping(target = "message", source = "errorMessage")
    @Mapping(target = "path", source = "path")
    ApiError toDto(String errorCode, String errorMessage, String path, @Context String requestId);
}