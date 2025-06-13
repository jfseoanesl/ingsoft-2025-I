package com.design_patterns.builder.service;

import com.design_patterns.builder.domain.HotelReservation;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ReservationService {

    public HotelReservation createSampleReservation() {
        HotelReservation reservation = new HotelReservation(
                "John Doe",
                "Hotel Primavera",
                LocalDate.of(2025, 7, 1),
                LocalDate.of(2025, 7, 5),
                true,
                false,
                "Late check-in"
        );

        return reservation;
    }
}
