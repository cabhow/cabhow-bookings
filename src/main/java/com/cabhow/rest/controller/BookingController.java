package com.cabhow.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cabhow.rest.model.Booking;
import com.cabhow.rest.service.BookingService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("v1/")
public class BookingController {

	@Autowired
	BookingService service;

	@GetMapping("/getAllBookings")
	@ApiOperation(tags = "cabhow-bookings", value = "cabhow-bookings", response = List.class, produces = "application/json")
	public ResponseEntity<List<Booking>> getAllBookings() {
		ResponseEntity<List<Booking>> respEntity = null;
		List<Booking> allBookings = service.getAllBooking();
		respEntity = ResponseEntity.ok().body(allBookings);
		return respEntity;
	}

	@GetMapping("/getBookingById/{id}")
	@ApiOperation(tags = "cabhow-bookings", value = "cabhow-bookings", response = Booking.class, produces = "application/json")
	public ResponseEntity<Booking> getBookingById(@PathVariable(value = "id") long id) {
		ResponseEntity<Booking> respEntity = null;
		Booking fetchedBooking = service.getBookingById(id);
		respEntity = ResponseEntity.ok().body(fetchedBooking);
		return respEntity;
	}

	@PostMapping("/addBooking")
	@ApiOperation(tags = "cabhow-bookings", value = "cabhow-bookings", consumes = "application/json", response = Booking.class, produces = "application/json")
	public ResponseEntity<Booking> addBooking(@Valid @RequestBody Booking booking) {
		ResponseEntity<Booking> respEntity = null;
		Booking addedBooking = service.addBooking(booking);
		respEntity = ResponseEntity.ok().body(addedBooking);
		return respEntity;
	}
	
	@PutMapping("/updateBooking/{id}")
	@ApiOperation(tags = "cabhow-bookings", value = "cabhow-bookings", consumes = "application/json", response = Booking.class, produces = "application/json")
	public ResponseEntity<Booking> updateBooking(@PathVariable(value = "id") long id, @Valid @RequestBody Booking booking) {
		ResponseEntity<Booking> respEntity = null;
		Booking updatedBooking = service.updateBooking(id, booking);
		respEntity = ResponseEntity.ok().body(updatedBooking);
		return respEntity;
	}
}
