package org.example.billingsystem;

public class BillingPayRequest {

    private double ammount;
    private Long customerId;

    public BillingPayRequest(double ammount, Long customerId) {
        this.ammount = ammount;
        this.customerId = customerId;
    }

    public double getAmmount() {
        return ammount;
    }

    public void setAmmount(double ammount) {
        this.ammount = ammount;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
