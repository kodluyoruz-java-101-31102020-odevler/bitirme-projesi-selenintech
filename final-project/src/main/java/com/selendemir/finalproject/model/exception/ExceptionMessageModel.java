package com.selendemir.finalproject.model.exception;

import java.io.Serializable;
import java.util.UUID;

public class ExceptionMessageModel implements Serializable {

    private static final long serialVersionUID = -115857376526176165L;

    private String errorId;
    private String message;
    private long timestamp;

    public ExceptionMessageModel(String message) {
        this.message = message;
        this.errorId = UUID.randomUUID().toString();
        this.timestamp = System.currentTimeMillis();
    }

    public String getErrorId() {
        return errorId;
    }

    public String getMessage() {
        return message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "errorId='" + errorId + '\'' +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp ;
    }
}
