package com.cabhow.rest.service;

import com.cabhow.rest.exception.ResourceNotFoundException;
import com.cabhow.rest.model.Booking;
import com.cabhow.rest.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

	@Autowired
	BookingRepository repository;

	public List<Booking> getAllBooking() {
		List<Booking> allBookings = repository.findAll();
		return allBookings;
	}

	public Booking getBookingById(Long id) {
		Booking fetchedBooking = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Booking", "id", id));
		return fetchedBooking;
	}

	public Booking addBooking(Booking booking) {
		Booking addedBooking = repository.save(booking);
		return addedBooking;
	}

	public Booking updateBooking(long id, Booking booking) {
		//booking.setId(id);
		Booking addedBooking = repository.save(booking);
		return addedBooking;
	}

}
