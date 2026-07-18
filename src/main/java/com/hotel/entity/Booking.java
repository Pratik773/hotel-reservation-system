package com.hotel.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String guestName;

    private String guestEmail;

    private LocalDate checkIn;

    private LocalDate checkOut;

    private Double totalPrice;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
}