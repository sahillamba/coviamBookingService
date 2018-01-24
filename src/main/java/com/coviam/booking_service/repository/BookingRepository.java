package com.coviam.booking_service.repository;

import com.coviam.booking_service.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {

    Booking findByBookingReference(String bookingReference);
}
