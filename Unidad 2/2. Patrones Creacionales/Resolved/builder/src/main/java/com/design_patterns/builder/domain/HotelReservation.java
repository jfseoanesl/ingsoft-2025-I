package com.design_patterns.builder.domain;

import com.design_patterns.builder.domain.builder.IBuilder;

import java.time.LocalDate;

public class HotelReservation {

    private String customerName;
    private String hotelName;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private boolean breakfastIncluded;
    private boolean airportShuttle;
    private String specialRequests;

    private HotelReservation(ReservationsBuilder builder){
        this.customerName = builder.customerName;
        this.hotelName = builder.hotelName;
        this.checkInDate = builder.checkInDate;
        this.checkOutDate = builder.checkOutDate;
        this.breakfastIncluded = builder.breakfastIncluded;
        this.airportShuttle = builder.airportShuttle;
        this.specialRequests = builder.specialRequests;
    }
    private HotelReservation(String customerName, String hotelName, LocalDate checkInDate, LocalDate checkOutDate) {
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

    public static class ReservationsBuilder implements IBuilder {
        private String customerName;
        private String hotelName;
        private LocalDate checkInDate;
        private LocalDate checkOutDate;
        private boolean breakfastIncluded;
        private boolean airportShuttle;
        private String specialRequests;

        public ReservationsBuilder() {
        }

        public ReservationsBuilder customerName(String customerName) {
            this.customerName = customerName;
            return this;
        }
        public ReservationsBuilder hotelName(String hotelName) {
            this.hotelName = hotelName;
            return this;
        }

        public ReservationsBuilder checkInDate(LocalDate checkInDate) {
            this.checkInDate = checkInDate;
            return this;
        }

        public ReservationsBuilder checkOutDate(LocalDate checkOutDate) {
            this.checkOutDate = checkOutDate;
            return this;
        }

        public ReservationsBuilder breakfastIncluded(boolean breakfastIncluded) {
            this.breakfastIncluded = breakfastIncluded;
            return this;
        }
        public ReservationsBuilder airportShuttle(boolean airportShuttle) {
             this.airportShuttle = airportShuttle;
             return this;
        }

        public ReservationsBuilder specialRequests(String specialRequests) {
            this.specialRequests = specialRequests;
            return this;
        }

        @Override
        public HotelReservation build() {
            return new HotelReservation(this);
        }
    }
}

