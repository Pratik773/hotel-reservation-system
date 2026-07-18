package com.hotel.controller;

import com.hotel.dto.RoomRequest;
import com.hotel.dto.RoomResponse;
import com.hotel.service.RoomService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/hotel/{hotelId}")
    public ResponseEntity<RoomResponse> addRoom(
            @PathVariable Long hotelId,
            @Valid @RequestBody RoomRequest request) {

        RoomResponse response = roomService.addRoom(hotelId, request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<RoomResponse>> getRoomsByHotel(
            @PathVariable Long hotelId) {

        return ResponseEntity.ok(
                roomService.getRoomsByHotel(hotelId)
        );
    }
    @GetMapping("/{roomId}")
    public ResponseEntity<RoomResponse> getRoomById(
            @PathVariable Long roomId) {

        return ResponseEntity.ok(
                roomService.getRoomById(roomId)
        );
    }
    @PutMapping("/{roomId}")
    public ResponseEntity<RoomResponse> updateRoom(
            @PathVariable Long roomId,
            @Valid @RequestBody RoomRequest request) {

        return ResponseEntity.ok(
                roomService.updateRoom(roomId, request)
        );
    }
    @DeleteMapping("/{roomId}")
    public ResponseEntity<Void> deleteRoom(
            @PathVariable Long roomId) {

        roomService.deleteRoom(roomId);

        return ResponseEntity.noContent().build();
    }

}