package com.design_patterns.builder.domain;

import java.time.LocalDate;

public class HotelReservation {

    private String customerName;
    private String hotelName;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private boolean breakfastIncluded;
    private boolean airportShuttle;
    private String specialRequests;

    public HotelReservation(String customerName, String hotelName, LocalDate checkInDate, LocalDate checkOutDate) {
        this(customerName, hotelName, checkInDate, checkOutDate, false);
    }

    public HotelReservation(String customerName, String hotelName, LocalDate checkInDate, LocalDate checkOutDate, boolean breakfastIncluded) {
        this(customerName, hotelName, checkInDate, checkOutDate, breakfastIncluded, false);
    }

    public HotelReservation(String customerName, String hotelName, LocalDate checkInDate, LocalDate checkOutDate,
                            boolean breakfastIncluded, boolean airportShuttle) {
        this(customerName, hotelName, checkInDate, checkOutDate, breakfastIncluded, airportShuttle, null);
    }

    public HotelReservation(String customerName, String hotelName, LocalDate checkInDate, LocalDate checkOutDate,
                            boolean breakfastIncluded, boolean airportShuttle, String specialRequests) {
        this.customerName = customerName;
        this.hotelName = hotelName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.breakfastIncluded = breakfastIncluded;
        this.airportShuttle = airportShuttle;
        this.specialRequests = specialRequests;
    }

    @Override
    public String toString() {
        return "HotelReservation{" +
                "customerName='" + customerName + '\'' +
                ", hotelName='" + hotelName + '\'' +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", breakfastIncluded=" + breakfastIncluded +
                ", airportShuttle=" + airportShuttle +
                ", specialRequests='" + specialRequests + '\'' +
                '}';
    }
}

