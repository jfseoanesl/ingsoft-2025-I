package com.mycompany.openclosed.bad;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class ParkingManager {


    public static double calculateParkingCost(Vehicle v, LocalTime income, LocalTime exit){
        long hours = ChronoUnit.HOURS.between(exit, income);
        double cost = hours * v.getRate();
        return  cost;
    }


}
