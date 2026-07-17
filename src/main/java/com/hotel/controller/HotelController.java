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
    public ResponseEntity<List<HotelResponse>> getAllHotels() {

        return ResponseEntity.ok(hotelService.getAllHotels());

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
    public ResponseEntity<HotelResponse> getHotelById(
            @PathVariable Long id) {

        return ResponseEntity.ok(hotelService.getHotelById(id));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable Long id) {

        hotelService.deleteHotel(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<HotelResponse> updateHotel(
            @PathVariable Long id,
            @Valid @RequestBody HotelRequest request) {

        HotelResponse response = hotelService.updateHotel(id, request);

        return ResponseEntity.ok(response);
    }
    @GetMapping("/search")
    public ResponseEntity<List<HotelResponse>> getHotelsByCity(
            @RequestParam String city) {

        return ResponseEntity.ok(hotelService.getHotelsByCity(city));
    }

}