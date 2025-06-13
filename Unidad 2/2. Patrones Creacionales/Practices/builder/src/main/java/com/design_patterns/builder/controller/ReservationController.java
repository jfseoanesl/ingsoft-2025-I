package com.design_patterns.builder.controller;

import com.design_patterns.builder.domain.HotelReservation;
import com.design_patterns.builder.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/create")
    public ResponseEntity<?> createReservation() {
        HotelReservation reservation = reservationService.createSampleReservation();
        return ResponseEntity.ok("Reserva creada: " + reservation);
    }
}
