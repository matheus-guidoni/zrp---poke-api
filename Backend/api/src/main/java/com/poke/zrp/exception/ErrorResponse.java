package com.poke.zrp.exception;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ErrorResponse {
    private int status;
    private String error;
    private String message;
    private String timestamp;

    public ErrorResponse(int status, String error, String message) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.timestamp = ZonedDateTime.now(ZoneOffset.UTC)
                                      .format(DateTimeFormatter.ISO_INSTANT);;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
