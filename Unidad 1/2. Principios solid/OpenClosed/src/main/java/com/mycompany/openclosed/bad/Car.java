package com.mycompany.openclosed.bad;

public class Car extends Vehicle {

    private final double RATE_CAR = 2000;

    public Car(String matricule, String type) {
        super(matricule, type);
    }

    @Override
    public double getRate() {
        return this.RATE_CAR;
    }
}
