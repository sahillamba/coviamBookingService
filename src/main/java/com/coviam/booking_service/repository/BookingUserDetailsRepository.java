package com.coviam.booking_service.repository;


import com.coviam.booking_service.model.BookingUserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingUserDetailsRepository extends JpaRepository<BookingUserDetails,Long>  {
}
