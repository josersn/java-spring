package com.backend.healthserviceasservice.domain.utils;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public final class TimeNowUtils {

    private TimeNowUtils() {}

    public static Instant now() {
        return Instant.now().truncatedTo(ChronoUnit.MICROS);
    }
}
