package com.mycompany.openclosed.bad;

public class Truck extends Vehicle {
    private final double RATE_TRUCK = 4000;

    public Truck(String matricule, String type) {
        super(matricule, type);
    }

    @Override
    public double getRate() {
        return this.RATE_TRUCK;
    }

}
