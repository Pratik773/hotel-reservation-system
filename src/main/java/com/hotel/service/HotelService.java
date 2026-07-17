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

            response.add(
                    mapToResponse(hotel)
            );

        }

        return response;

    }

    public HotelResponse addHotel(HotelRequest request) {

        Hotel hotel = new Hotel();

        hotel.setName(request.getName());
        hotel.setCity(request.getCity());
        hotel.setPrice(request.getPrice());

        Hotel savedHotel = hotelRepository.save(hotel);

        return new HotelResponse(
                savedHotel.getId(),
                savedHotel.getName(),
                savedHotel.getCity(),
                savedHotel.getPrice()
        );
    }

    public HotelResponse getHotelById(Long id) {

        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new HotelNotFoundException(id));

        return new HotelResponse(
                hotel.getId(),
                hotel.getName(),
                hotel.getCity(),
                hotel.getPrice()
        );

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
    private HotelResponse mapToResponse(Hotel hotel) {

        return mapToResponse(hotel);

    }
}