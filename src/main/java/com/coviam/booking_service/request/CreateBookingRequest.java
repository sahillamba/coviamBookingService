package com.coviam.booking_service.request;

import com.coviam.booking_service.model.BookingUserDetails;

import java.util.List;

public class CreateBookingRequest {
    private String customer_id;
    private String booking_type;
    private String booking_source;
    private String booking_phone_number;
    private String booking_email;
    private String super_pnr;

    private List<BookingUserDetails> user_details;

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getBooking_type() {
        return booking_type;
    }

    public void setBooking_type(String booking_type) {
        this.booking_type = booking_type;
    }

    public String getBooking_source() {
        return booking_source;
    }

    public void setBooking_source(String booking_source) {
        this.booking_source = booking_source;
    }

    public String getBooking_phone_number() {
        return booking_phone_number;
    }

    public void setBooking_phone_number(String booking_phone_number) {
        this.booking_phone_number = booking_phone_number;
    }

    public String getBooking_email() {
        return booking_email;
    }

    public void setBooking_email(String booking_email) {
        this.booking_email = booking_email;
    }

    public String getSuper_pnr() {
        return super_pnr;
    }

    public void setSuper_pnr(String super_pnr) {
        this.super_pnr = super_pnr;
    }

    public List<BookingUserDetails> getUser_details() {
        return user_details;
    }

    public void setUser_details(List<BookingUserDetails> user_details) {
        this.user_details = user_details;
    }

    public CreateBookingRequest() {
    }

    public CreateBookingRequest(String customer_id, String booking_type, String booking_source, String booking_phone_number, String booking_email, String super_pnr, List<BookingUserDetails> user_details) {
        this.customer_id = customer_id;
        this.booking_type = booking_type;
        this.booking_source = booking_source;
        this.booking_phone_number = booking_phone_number;
        this.booking_email = booking_email;
        this.super_pnr = super_pnr;
        this.user_details = user_details;
    }
}
