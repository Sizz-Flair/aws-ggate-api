package com.sms.ggateapi.domain.order.dto;

import java.time.Instant;

public record OrderDt(long seconds, int nanos) {
    public Instant toInstant() {
        return Instant.ofEpochSecond(seconds, nanos);
    }
}