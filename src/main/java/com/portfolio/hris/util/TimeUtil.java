package com.portfolio.hris.util;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatterBuilder;

@Component
public class TimeUtil {
    public String nowDateString() {
        return LocalDateTime.now().format(new DateTimeFormatterBuilder().appendPattern("yyyyMMdd").toFormatter());
    }

    public String nowDateTimeString() {
        return LocalDateTime.now().format(new DateTimeFormatterBuilder().appendPattern("yyyyMMddHHmmss").toFormatter());
    }
}
