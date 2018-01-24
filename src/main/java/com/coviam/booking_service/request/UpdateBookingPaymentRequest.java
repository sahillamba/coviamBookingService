package com.coviam.booking_service.request;

public class UpdateBookingPaymentRequest {
    private String booking_reference;
    private String payment_id;

    public String getBooking_reference() {
        return booking_reference;
    }

    public void setBooking_reference(String booking_reference) {
        this.booking_reference = booking_reference;
    }

    public String getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(String payment_id) {
        this.payment_id = payment_id;
    }

    public UpdateBookingPaymentRequest() {
    }

    public UpdateBookingPaymentRequest(String booking_reference, String payment_id) {
        this.booking_reference = booking_reference;
        this.payment_id = payment_id;
    }
}
