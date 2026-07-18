package com.hotel.service;

import com.hotel.dto.RoomRequest;
import com.hotel.dto.RoomResponse;
import com.hotel.entity.Hotel;
import com.hotel.entity.Room;
import com.hotel.exception.HotelNotFoundException;
import com.hotel.repository.HotelRepository;
import com.hotel.repository.RoomRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;

    public RoomService(RoomRepository roomRepository,
                       HotelRepository hotelRepository) {

        this.roomRepository = roomRepository;
        this.hotelRepository = hotelRepository;
    }

    public RoomResponse addRoom(Long hotelId, RoomRequest request) {

        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new HotelNotFoundException(hotelId));

        Room room = new Room();

        room.setRoomNumber(request.getRoomNumber());
        room.setRoomType(request.getRoomType());
        room.setPricePerNight(request.getPricePerNight());
        room.setAvailable(request.getAvailable());

        room.setHotel(hotel);

        Room savedRoom = roomRepository.save(room);

        return mapToResponse(savedRoom);
    }

    private RoomResponse mapToResponse(Room room) {

        return new RoomResponse(
                room.getId(),
                room.getRoomNumber(),
                room.getRoomType(),
                room.getPricePerNight(),
                room.getAvailable(),
                room.getHotel().getId(),
                room.getHotel().getName()
        );
    }
    public List<RoomResponse> getRoomsByHotel(Long hotelId) {

        // Check if hotel exists
        hotelRepository.findById(hotelId)
                .orElseThrow(() -> new HotelNotFoundException(hotelId));

        List<Room> rooms = roomRepository.findByHotelId(hotelId);

        List<RoomResponse> response = new ArrayList<>();

        for (Room room : rooms) {
            response.add(mapToResponse(room));
        }

        return response;
    }

    public RoomResponse getRoomById(Long roomId) {

        Room room = roomRepository.findById(roomId)
                .orElseThrow(() ->
                        new RuntimeException("Room not found with id: " + roomId));

        return mapToResponse(room);
    }
    public RoomResponse updateRoom(Long roomId,
                                   RoomRequest request) {

        Room room = roomRepository.findById(roomId)
                .orElseThrow(() ->
                        new RuntimeException("Room not found with id: " + roomId));

        room.setRoomNumber(request.getRoomNumber());
        room.setRoomType(request.getRoomType());
        room.setPricePerNight(request.getPricePerNight());
        room.setAvailable(request.getAvailable());

        Room updatedRoom = roomRepository.save(room);

        return mapToResponse(updatedRoom);
    }
    public void deleteRoom(Long roomId) {

        Room room = roomRepository.findById(roomId)
                .orElseThrow(() ->
                        new RuntimeException("Room not found with id: " + roomId));

        roomRepository.delete(room);
    }

}