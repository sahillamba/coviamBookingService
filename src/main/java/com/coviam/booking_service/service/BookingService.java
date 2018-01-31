package com.coviam.booking_service.service;

import com.coviam.booking_service.model.Booking;
import com.coviam.booking_service.model.BookingUserDetails;
import com.coviam.booking_service.repository.BookingRepository;
import com.coviam.booking_service.repository.BookingUserDetailsRepository;
import com.coviam.booking_service.request.CreateBookingRequest;
import com.coviam.booking_service.request.UpdateBookingPaymentRequest;
import com.coviam.booking_service.response.UpdateBookingResponse;
import com.coviam.booking_service.util.RandomGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    BookingUserDetailsRepository bookingUserDetailsRepository;

    @Autowired
    RandomGenerator randomGenerator;

    public Booking getBooking(String booking_reference){
        return bookingRepository.findByBookingReference(booking_reference);
    }

    public Booking createBooking(CreateBookingRequest request){
        Booking newBooking = new Booking(request.getCustomer_id(), randomGenerator.generateRandomString(),request.getSuper_pnr(), Booking.Status.pending,"",Booking.Status.pending,request.getBooking_type(),request.getBooking_source(),request.getBooking_phone_number(),request.getBooking_email());
        newBooking.setBookingUserDetails(request.getUser_details());
        Booking newBookingResponse = bookingRepository.save(newBooking);
        return newBookingResponse;
    }

    public UpdateBookingResponse updateBookingPaymentSuccessful(UpdateBookingPaymentRequest request){
        Booking current_booking = this.getBooking(request.getBooking_reference());

        current_booking.setBooking_status(Booking.Status.successful);
        current_booking.setPayment_status(Booking.Status.successful);
        current_booking.setPayment_id(request.getPayment_id());

        Booking saved_booking = bookingRepository.save(current_booking);

        UpdateBookingResponse response;
        if(saved_booking != null){
             response = new UpdateBookingResponse(true,200);
        }else{
             response = new UpdateBookingResponse(false,201,"Update Booking Failed");
        }
        return response;
    }

    public UpdateBookingResponse updateBookingPaymentError(UpdateBookingPaymentRequest request){
        Booking current_booking = this.getBooking(request.getBooking_reference());

        current_booking.setBooking_status(Booking.Status.deferred);
        current_booking.setPayment_status(Booking.Status.deferred);
        current_booking.setPayment_id(request.getPayment_id());

        Booking saved_booking = bookingRepository.save(current_booking);

        UpdateBookingResponse response;
        if(saved_booking != null){
            response = new UpdateBookingResponse(true,200);
        }else{
            response = new UpdateBookingResponse(false,201,"Update Booking Failed");
        }
        return response;
    }

    public UpdateBookingResponse updateBookingPaymentCancel(UpdateBookingPaymentRequest request){
        Booking current_booking = this.getBooking(request.getBooking_reference());

        current_booking.setBooking_status(Booking.Status.cancelled);
        current_booking.setPayment_status(Booking.Status.cancelled);
        current_booking.setPayment_id(request.getPayment_id());

        Booking saved_booking = bookingRepository.save(current_booking);

        UpdateBookingResponse response;
        if(saved_booking != null){
            response = new UpdateBookingResponse(true,200);
        }else{
            response = new UpdateBookingResponse(false,201,"Update Booking Failed");
        }
        return response;
    }
}
