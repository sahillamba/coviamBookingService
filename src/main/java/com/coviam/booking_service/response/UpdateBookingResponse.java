package com.coviam.booking_service.response;

public class UpdateBookingResponse {

    private boolean success;

    private int status;

    private String errorMessage;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public UpdateBookingResponse() {
    }

    public UpdateBookingResponse(boolean success, int status) {
        this.success = success;
        this.status = status;
    }

    public UpdateBookingResponse(boolean success, int status, String errorMessage) {
        this.success = success;
        this.status = status;
        this.errorMessage = errorMessage;
    }
}
