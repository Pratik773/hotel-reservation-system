package com.hotel.controller;

import com.hotel.dto.HotelResponse;
import com.hotel.dto.HotelRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.hotel.entity.Hotel;
import com.hotel.service.HotelService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/hotels")
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }

    @PostMapping
    public ResponseEntity<HotelResponse> addHotel(
            @Valid @RequestBody HotelRequest request) {

        HotelResponse response = hotelService.addHotel(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable Long id) {

        return ResponseEntity.ok(hotelService.getHotelById(id));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable Long id) {

        hotelService.deleteHotel(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hotel> updateHotel(
            @PathVariable Long id,
            @Valid @RequestBody Hotel hotel) {

        Hotel updatedHotel = hotelService.updateHotel(id, hotel);

        return ResponseEntity.ok(updatedHotel);

    }

}