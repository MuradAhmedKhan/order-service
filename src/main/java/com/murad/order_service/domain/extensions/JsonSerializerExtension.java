package com.murad.order_service.domain.extensions;

import org.springframework.stereotype.Component;

import com.murad.order_service.domain.constants.ErrorCodes;
import com.murad.order_service.domain.exceptions.SerializationException;

import lombok.RequiredArgsConstructor;
import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;

@Component
@RequiredArgsConstructor
public final class JsonSerializerExtension {
    private final ObjectMapper mapper;

    public final String toJson(Object obj){
        try {
            return mapper.writeValueAsString(obj);
        } catch (JacksonException e) {
            throw new SerializationException(ErrorCodes.INVALID_SERIALIZATION);
        }
    }

    public final <T> T fromJson(String json, Class<T> class1){
        try {
            return mapper.readValue(json, class1);
        } catch (JacksonException e) {
            throw new SerializationException(ErrorCodes.INVALID_SERIALIZATION);
        }
    }
}