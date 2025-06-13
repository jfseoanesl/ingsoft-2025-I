package com.design_pattern.adapter.model;

public class PaymentRequest {

    private String customId;
    private double amount;
    private String currency;
    private String account;
    private PaymentSystem type;

    public PaymentRequest() {
    }

    public PaymentRequest(String customId, double amount, String currency, String account, PaymentSystem type) {
        this.customId = customId;
        this.amount = amount;
        this.currency = currency;
        this.account = account;
        this.type = type;
    }

    public String getCustomId() {
        return customId;
    }

    public void setCustomId(String customId) {
        this.customId = customId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public PaymentSystem getType() {
        return type;
    }

    public void setType(PaymentSystem type) {
        this.type = type;
    }
}
