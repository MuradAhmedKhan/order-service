package com.murad.order_service.domain.errors;

import java.time.Instant;

public record ApiError(
    String code,
    String message,
    Instant timeStamp,
    String path,
    String requestId
) {}