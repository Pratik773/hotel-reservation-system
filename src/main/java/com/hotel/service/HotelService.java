package com.hotel.service;

import com.hotel.dto.HotelRequest;
import com.hotel.dto.HotelResponse;
import com.hotel.exception.HotelNotFoundException;
import com.hotel.entity.Hotel;
import com.hotel.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<HotelResponse> getAllHotels() {

        List<Hotel> hotels = hotelRepository.findAll();

        List<HotelResponse> response = new ArrayList<>();

        for (Hotel hotel : hotels) {
            response.add(mapToResponse(hotel));
        }

        return response;
    }

    public HotelResponse addHotel(HotelRequest request) {

        Hotel hotel = new Hotel();

        hotel.setName(request.getName());
        hotel.setCity(request.getCity());
        hotel.setPrice(request.getPrice());

        Hotel savedHotel = hotelRepository.save(hotel);

        return mapToResponse(savedHotel);
    }

    public HotelResponse getHotelById(Long id) {

        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new HotelNotFoundException(id));

        return mapToResponse(hotel);
    }

    public HotelResponse updateHotel(Long id, HotelRequest request) {

        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new HotelNotFoundException(id));

        hotel.setName(request.getName());
        hotel.setCity(request.getCity());
        hotel.setPrice(request.getPrice());

        Hotel updatedHotel = hotelRepository.save(hotel);

        return mapToResponse(updatedHotel);
    }

    public void deleteHotel(Long id) {

        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new HotelNotFoundException(id));

        hotelRepository.delete(hotel);

    }
    private HotelResponse mapToResponse(Hotel hotel) {

        return new HotelResponse(
                hotel.getId(),
                hotel.getName(),
                hotel.getCity(),
                hotel.getPrice()
        );
    }
}