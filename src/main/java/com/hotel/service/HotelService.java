package com.hotel.service;

import com.hotel.exception.HotelNotFoundException;
import com.hotel.entity.Hotel;
import com.hotel.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public Hotel addHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public Hotel getHotelById(Long id) {
        return hotelRepository.findById(id).orElseThrow(() -> new HotelNotFoundException(id));
    }

    public Hotel updateHotel(Long id, Hotel updatedHotel) {

        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new HotelNotFoundException(id));

        hotel.setName(updatedHotel.getName());
        hotel.setCity(updatedHotel.getCity());
        hotel.setPrice(updatedHotel.getPrice());

        return hotelRepository.save(hotel);
    }

    public void deleteHotel(Long id) {

        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new HotelNotFoundException(id));

        hotelRepository.delete(hotel);

    }
}