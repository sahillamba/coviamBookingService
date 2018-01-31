package com.coviam.booking_service.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity(name="BookingUserDetails")
@Table(name="booking_user_details")
public class BookingUserDetails {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="user_name")
    private String user_name;

    @Column(name="user_age")
    private String user_age;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    @JsonBackReference
    private Booking booking;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_age() {
        return user_age;
    }

    public void setUser_age(String user_age) {
        this.user_age = user_age;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public BookingUserDetails(){

    }

    public BookingUserDetails(String user_name, String user_age) {
        this.user_name = user_name;
        this.user_age = user_age;
    }
}
