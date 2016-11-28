package com.money.exception;

/**
 *
 * Created by eric.nascimento on 28/11/16.
 */
public class ResponseError {

    private String status;
    private String message;

    public ResponseError(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
