package com.murad.order_service.domain.exceptions;

import com.murad.order_service.domain.constants.ErrorCodes;
import com.murad.order_service.domain.exceptions.base.BaseException;

public class SerializationException extends BaseException{
    public SerializationException(ErrorCodes errorCodes, Object... object){
        super(errorCodes, object);
    }
}