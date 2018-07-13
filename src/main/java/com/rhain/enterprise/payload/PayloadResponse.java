package com.rhain.enterprise.payload;

public class PayloadResponse<T> {
    private Boolean success;
    private String message;
    private T payload;

    public PayloadResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public PayloadResponse(Boolean success, T payload) {
        this.success = success;
        this.payload = payload;
    }

    public PayloadResponse(Boolean success, String message, T payload) {
        this.success = success;
        this.message = message;
        this.payload = payload;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }
}
