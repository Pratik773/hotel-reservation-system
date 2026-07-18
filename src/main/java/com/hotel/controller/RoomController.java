package com.hotel.controller;

import com.hotel.dto.RoomRequest;
import com.hotel.dto.RoomResponse;
import com.hotel.service.RoomService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}