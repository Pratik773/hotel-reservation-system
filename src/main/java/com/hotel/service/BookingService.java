package com.hotel.service;

import com.hotel.dto.BookingRequest;
import com.hotel.dto.BookingResponse;
import com.hotel.entity.Booking;
import com.hotel.entity.Room;
import com.hotel.repository.BookingRepository;
import com.hotel.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;

    public BookingService(BookingRepository bookingRepository,
                          RoomRepository roomRepository) {

        this.bookingRepository = bookingRepository;
        this.roomRepository = roomRepository;
    }

    public BookingResponse createBooking(Long roomId,
                                         BookingRequest request) {

        Room room = roomRepository.findById(roomId)
                .orElseThrow(() ->
                        new RuntimeException("Room not found with id: " + roomId));

        if (!isRoomAvailable(room, request)) {
            throw new RuntimeException(
                    "Room is already booked for the selected dates."
            );
        }
        long totalDays = ChronoUnit.DAYS.between(
                request.getCheckIn(),
                request.getCheckOut()
        );

        if (totalDays <= 0) {
            throw new RuntimeException("Check-out date must be after check-in date.");
        }

        Double totalPrice = totalDays * room.getPricePerNight();

        Booking booking = new Booking();

        booking.setGuestName(request.getGuestName());
        booking.setGuestEmail(request.getGuestEmail());
        booking.setCheckIn(request.getCheckIn());
        booking.setCheckOut(request.getCheckOut());
        booking.setTotalPrice(totalPrice);
        booking.setRoom(room);

        Booking savedBooking = bookingRepository.save(booking);

        return mapToResponse(savedBooking);
    }

    private BookingResponse mapToResponse(Booking booking) {

        return new BookingResponse(
                booking.getId(),
                booking.getGuestName(),
                booking.getGuestEmail(),
                booking.getCheckIn(),
                booking.getCheckOut(),
                booking.getTotalPrice(),
                booking.getRoom().getId(),
                booking.getRoom().getRoomNumber()
        );
    }
    private boolean isRoomAvailable(Room room,
                                    BookingRequest request) {

        List<Booking> bookings =
                bookingRepository.findByRoomId(room.getId());

        for (Booking booking : bookings) {

            boolean overlap =
                    request.getCheckIn().isBefore(booking.getCheckOut())
                            &&
                            request.getCheckOut().isAfter(booking.getCheckIn());

            if (overlap) {
                return false;
            }

        }

        return true;
    }
}