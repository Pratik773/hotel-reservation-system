package com.hotel.service;

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
        return hotelRepository.findById(id).orElse(null);
    }

    public Hotel updateHotel(Long id, Hotel updatedHotel) {

        Hotel hotel = hotelRepository.findById(id).orElse(null);

        if (hotel == null) {
            return null;
        }

        hotel.setName(updatedHotel.getName());
        hotel.setCity(updatedHotel.getCity());
        hotel.setPrice(updatedHotel.getPrice());

        return hotelRepository.save(hotel);
    }

    public boolean deleteHotel(Long id) {

        if (!hotelRepository.existsById(id)) {
            return false;
        }

        hotelRepository.deleteById(id);
        return true;
    }
}