package com.design_pattern.facade.model;

public class ShippingQuote {
    private double cost;
    private int estimatedDays;
    private String trackingNumber;

    public ShippingQuote(double cost, int estimatedDays, String trackingNumber) {
        this.cost = cost;
        this.estimatedDays = estimatedDays;
        this.trackingNumber = trackingNumber;
    }

    // Getters y setters
    public double getCost() { return cost; }
    public int getEstimatedDays() { return estimatedDays; }
    public String getTrackingNumber() { return trackingNumber; }
}
