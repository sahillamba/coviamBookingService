package com.coviam.booking_service.model;

import com.coviam.booking_service.util.Auditable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.validator.constraints.Email;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.persistence.Id;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.coviam.booking_service.model.Booking.Status.pending;

@Entity(name="BookingMaster")
@Table(name="booking_master")
@EntityListeners(AuditingEntityListener.class)
public class Booking extends Auditable<String> {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="customer_id")
    private String customer_id;

    @Column(name="booking_reference")
    private String bookingReference;

    @Column(name="super_pnr")
    private String super_pnr;

    public static enum Status {pending, successful, deferred, cancelled};

    @Column(name="booking_status")
    @Enumerated(EnumType.STRING)
    private Status booking_status = pending;

    @Column(name="payment_id",nullable = true)
    private String payment_id = null;

    @Column(name="payment_status")
    @Enumerated(EnumType.STRING)
    private Status payment_status = pending;

    @Column(name="booking_type")
    private String booking_type = "fight";

    @Column(name="booking_source")
    private String booking_source = "web";

    @Column(name="booking_phone_number")
    private String phone_number;

    @Column(name="booking_email")
    private String booking_email;

    public String getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(String payment_id) {
        this.payment_id = payment_id;
    }

    @OneToMany(
            mappedBy = "booking",
            cascade = CascadeType.ALL,
            fetch=FetchType.EAGER
    )
    @JsonManagedReference
    private List<BookingUserDetails> bookingUserDetails = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getBookingReference() {
        return bookingReference;
    }

    public void setBookingReference(String bookingReference) {
        this.bookingReference = bookingReference;
    }

    public Status getBooking_status() {
        return booking_status;
    }

    public void setBooking_status(Status booking_status) {
        this.booking_status = booking_status;
    }

    public String getSuper_pnr() {
        return super_pnr;
    }

    public void setSuper_pnr(String super_pnr) {
        this.super_pnr = super_pnr;
    }

    public Status getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(Status payment_status) {
        this.payment_status = payment_status;
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

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getBooking_email() {
        return booking_email;
    }

    public void setBooking_email(String booking_email) {
        this.booking_email = booking_email;
    }

    public List<BookingUserDetails> getBookingUserDetails() {
        return bookingUserDetails;
    }

    public void setBookingUserDetails(List<BookingUserDetails> bookingUserDetails) {
        this.bookingUserDetails = bookingUserDetails;
    }

    public Booking(){

    }

    public Booking(String customer_id, String bookingReference, String super_pnr, Status booking_status, String payment_id, Status payment_status, String booking_type, String booking_source, String phone_number, String booking_email) {
        this.customer_id = customer_id;
        this.bookingReference = bookingReference;
        this.super_pnr = super_pnr;
        this.booking_status = booking_status;
        this.payment_id = payment_id;
        this.payment_status = payment_status;
        this.booking_type = booking_type;
        this.booking_source = booking_source;
        this.phone_number = phone_number;
        this.booking_email = booking_email;
    }
}
