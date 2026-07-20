package com.hotel.exception;

public class RoomAlreadyBookedException extends RuntimeException {

    public RoomAlreadyBookedException() {
        super("Room is already booked for the selected dates.");
    }
}