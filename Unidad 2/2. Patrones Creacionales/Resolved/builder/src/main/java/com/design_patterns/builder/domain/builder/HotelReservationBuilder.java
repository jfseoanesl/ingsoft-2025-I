package com.design_patterns.builder.domain.builder;

import com.design_patterns.builder.domain.HotelReservation;

import java.net.http.WebSocket;
import java.time.LocalDate;

public class HotelReservationBuilder implements IBuilder {

    private String customerName;
    private String hotelName;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private boolean breakfastIncluded;
    private boolean airportShuttle;
    private String specialRequests;

    public HotelReservationBuilder() {
    }

    public HotelReservationBuilder customerName(String customerName) {
        this.customerName = customerName;
        return this;
    }
    public HotelReservationBuilder hotelName(String hotelName) {
        this.hotelName = hotelName;
        return this;
    }

    public HotelReservationBuilder checkInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
        return this;
    }

    public HotelReservationBuilder checkOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
        return this;
    }

    public HotelReservationBuilder breakfastIncluded(boolean breakfastIncluded) {
        this.breakfastIncluded = breakfastIncluded;
        return this;
    }
    public HotelReservationBuilder airportShuttle(boolean airportShuttle) {
        this.airportShuttle = airportShuttle;
        return this;
    }

    public HotelReservationBuilder specialRequests(String specialRequests) {
        this.specialRequests = specialRequests;
        return this;
    }


    @Override
    public HotelReservation build() {
        return new HotelReservation(this.customerName,
                this.hotelName, this.checkInDate, this.checkOutDate,
                this.breakfastIncluded, this.airportShuttle, this.specialRequests);
    }
}
