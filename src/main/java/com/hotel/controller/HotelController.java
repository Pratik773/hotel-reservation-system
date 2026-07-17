package com.hotel.controller;

import com.hotel.entity.Hotel;
import com.hotel.service.HotelService;
import org.springframework.web.bind.annotation.*;

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
    public Hotel addHotel(@RequestBody Hotel hotel) {
        return hotelService.addHotel(hotel);
    }

    @GetMapping("/{id}")
    public Hotel getHotelById(@PathVariable Long id) {

        return hotelService.getHotelById(id);

    }

    @DeleteMapping("/{id}")
    public String deleteHotel(@PathVariable Long id) {

        boolean deleted = hotelService.deleteHotel(id);

        if (deleted) {
            return "Hotel deleted successfully";
        }

        return "Hotel not found";
    }

    @PutMapping("/{id}")
    public Hotel updateHotel(@PathVariable Long id,
                             @RequestBody Hotel hotel) {

        return hotelService.updateHotel(id, hotel);

    }

}