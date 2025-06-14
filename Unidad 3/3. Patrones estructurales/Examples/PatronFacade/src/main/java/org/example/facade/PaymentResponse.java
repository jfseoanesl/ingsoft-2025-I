package org.example.facade;

public class PaymentResponse {

    private String paymentConfirmNumberM;
    private double balance;
    private String customerStatus;

    public PaymentResponse() {
    }

    public PaymentResponse(String paymentConfirmNumberM, double balance, String customerStatus) {
        this.paymentConfirmNumberM = paymentConfirmNumberM;
        this.balance = balance;
        this.customerStatus = customerStatus;
    }

    public String getPaymentConfirmNumberM() {
        return paymentConfirmNumberM;
    }

    public void setPaymentConfirmNumberM(String paymentConfirmNumberM) {
        this.paymentConfirmNumberM = paymentConfirmNumberM;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(String customerStatus) {
        this.customerStatus = customerStatus;
    }
}
