package com.cabhow.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cabhow.rest.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

}
