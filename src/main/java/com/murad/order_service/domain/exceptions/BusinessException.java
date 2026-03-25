package com.murad.order_service.domain.exceptions;

import com.murad.order_service.domain.constants.ErrorCodes;
import com.murad.order_service.domain.exceptions.base.BaseException;

public class BusinessException extends BaseException{
    public BusinessException(ErrorCodes errorCodes, Object... args){
        super(errorCodes, args);
    }
}