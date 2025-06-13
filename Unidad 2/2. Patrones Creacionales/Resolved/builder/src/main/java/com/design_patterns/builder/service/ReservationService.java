package com.design_patterns.builder.service;

import com.design_patterns.builder.domain.HotelReservation;
import com.design_patterns.builder.domain.builder.Director;
import com.design_patterns.builder.domain.builder.HotelReservationBuilder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ReservationService {

    public HotelReservation createSampleReservation() {
//        HotelReservation reservation = new HotelReservation(
//                "John Doe",
//                "Hotel Primavera",
//                LocalDate.of(2025, 7, 1),
//                LocalDate.of(2025, 7, 5),
//                true,
//                false,
//                "Late check-in"
//        );

//        HotelReservation reservation = new HotelReservation.ReservationsBuilder()
//                .customerName("jairo")
//                .airportShuttle(true)
//                .hotelName("california")
//                .build();

        HotelReservationBuilder builder= new HotelReservationBuilder();
        Director.configSilverReservation(builder);
        builder.customerName("Jairo");
        builder.hotelName("Sicarare");
        builder.checkInDate(LocalDate.of(2025,06,10));
        builder.checkOutDate(LocalDate.of(2025,06,20));

        HotelReservation reservation = builder.build();

        return reservation;
    }
}
