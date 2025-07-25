package com.example.EcommerceSpring.exception;

import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class ErrorResponse {
    private int status;
    private String message;
    private LocalDateTime timeStamp;

    public ErrorResponse(int status, String message, LocalDateTime timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }
}