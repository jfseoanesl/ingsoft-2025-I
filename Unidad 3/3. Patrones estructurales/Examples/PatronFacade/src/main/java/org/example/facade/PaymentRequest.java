package org.example.facade;

public class PaymentRequest {

    private Long customerId;
    private double ammount;
    private String cardNumber;
    private String cardName;
    private String cardExpDate;
    private String cardSecureNum;

    public PaymentRequest() {
    }

    public PaymentRequest(Long customerId, double ammount, String cardNumber, String cardName, String cardExpDate, String cardSecureNum) {
        this.customerId = customerId;
        this.ammount = ammount;
        this.cardNumber = cardNumber;
        this.cardName = cardName;
        this.cardExpDate = cardExpDate;
        this.cardSecureNum = cardSecureNum;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public double getAmmount() {
        return ammount;
    }

    public void setAmmount(double ammount) {
        this.ammount = ammount;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardExpDate() {
        return cardExpDate;
    }

    public void setCardExpDate(String cardExpDate) {
        this.cardExpDate = cardExpDate;
    }

    public String getCardSecureNum() {
        return cardSecureNum;
    }

    public void setCardSecureNum(String cardSecureNum) {
        this.cardSecureNum = cardSecureNum;
    }
}
