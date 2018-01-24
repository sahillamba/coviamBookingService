package com.coviam.booking_service.routes;


import com.coviam.booking_service.model.Booking;
import com.coviam.booking_service.model.BookingUserDetails;
import com.coviam.booking_service.request.CreateBookingRequest;
import com.coviam.booking_service.request.UpdateBookingPaymentRequest;
import com.coviam.booking_service.response.UpdateBookingResponse;
import com.coviam.booking_service.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingRoutes {

    @Autowired
    public BookingService bookingService;


    @RequestMapping(
            value = "/createBooking",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Booking createBooking(@RequestBody CreateBookingRequest request) {
         Booking newBooking = bookingService.createBooking(request);
         return newBooking;
    }


    @RequestMapping(
            value = "/get/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Booking getBooking(@PathVariable("id") String id) {
        return bookingService.getBooking(id);
    }

    @RequestMapping(
            value = "/updateBookingPaymentSuccessful",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public UpdateBookingResponse updateBookingPaymentSuccessful(@RequestBody UpdateBookingPaymentRequest request){
        UpdateBookingResponse response = bookingService.updateBookingPaymentSuccessful(request);
        return response;
    }

    @RequestMapping(
            value = "/updateBookingPaymentError",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public UpdateBookingResponse updateBookingPaymentError(@RequestBody UpdateBookingPaymentRequest request){
        UpdateBookingResponse response = bookingService.updateBookingPaymentError(request);
        return response;
    }

    @RequestMapping(
            value = "/updateBookingPaymentCancel",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public UpdateBookingResponse updateBookingPaymentCancel(@RequestBody UpdateBookingPaymentRequest request){
        UpdateBookingResponse response = bookingService.updateBookingPaymentCancel(request);
        return response;
    }
}
