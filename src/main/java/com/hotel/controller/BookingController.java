package com.hotel.controller;

import com.hotel.dto.BookingRequest;
import com.hotel.dto.BookingResponse;
import com.hotel.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/room/{roomId}")
    public ResponseEntity<BookingResponse> createBooking(
            @PathVariable Long roomId,
            @Valid @RequestBody BookingRequest request) {

        BookingResponse response =
                bookingService.createBooking(roomId, request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
}