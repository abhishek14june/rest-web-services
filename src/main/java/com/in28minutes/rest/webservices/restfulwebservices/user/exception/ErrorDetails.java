package com.in28minutes.rest.webservices.restfulwebservices.user.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ErrorDetails {
    LocalDateTime time;
    String message;

    public ErrorDetails(LocalDateTime time, String message) {
        this.time = time;
        this.message = message;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
