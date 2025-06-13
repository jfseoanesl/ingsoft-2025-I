package com.design_patterns.builder.domain.builder;

public class Director {

    public static void configGoldReservation(HotelReservationBuilder builder){

        builder.breakfastIncluded(true);
        builder.airportShuttle(true);
        builder.specialRequests("TV, WIFI, AIR, PISCINA, PARKING");

    }

    public static void configSilverReservation(HotelReservationBuilder builder){

        builder.breakfastIncluded(true);
        builder.airportShuttle(false);
        builder.specialRequests("TV, WIFI, AIR");

    }



}
