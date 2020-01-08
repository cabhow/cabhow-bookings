package com.cabhow.rest.controller;

import com.cabhow.rest.model.Booking;
import com.cabhow.rest.prod.bookings.api.AddApi;
import com.cabhow.rest.prod.bookings.api.GetBookingsApi;
import com.cabhow.rest.prod.bookings.model.AddBookingPayload;
import com.cabhow.rest.prod.bookings.model.GetBookingPayload;
import com.cabhow.rest.prod.bookings.model.InlineResponse200;
import com.cabhow.rest.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class BookingsController implements AddApi, GetBookingsApi {
    @Autowired
    BookingService service;

    @Override
    public ResponseEntity<Void> addBooking(@RequestBody AddBookingPayload addBookingPayload) {
        ResponseEntity<Booking> respEntity = null;
        Booking addedBooking = service.addBooking(new Booking());
        respEntity = ResponseEntity.ok().body(addedBooking);
        return null;
    }

    @Override
    public ResponseEntity<InlineResponse200> getBookings(@Valid GetBookingPayload getBookingPayload) {
        return null;
    }
}

