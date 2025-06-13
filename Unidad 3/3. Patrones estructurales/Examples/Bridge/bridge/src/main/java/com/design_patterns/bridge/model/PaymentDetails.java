package com.design_patterns.bridge.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PaymentDetails {
    private String paymentId;
    private BigDecimal amount;
    private String currency;
    private String description;
    private String customerEmail;
    private LocalDateTime createdAt;
    private String status;

    public PaymentDetails() {
        this.createdAt = LocalDateTime.now();
        this.status = "PENDING";
    }

    // Constructors
    public PaymentDetails(String paymentId, BigDecimal amount, String currency,
                          String description, String customerEmail) {
        this();
        this.paymentId = paymentId;
        this.amount = amount;
        this.currency = currency;
        this.description = description;
        this.customerEmail = customerEmail;
    }

    // Getters and Setters
    public String getPaymentId() { return paymentId; }
    public void setPaymentId(String paymentId) { this.paymentId = paymentId; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getCustomerEmail() { return customerEmail; }
    public void setCustomerEmail(String customerEmail) { this.customerEmail = customerEmail; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "PaymentDetails{" +
                "paymentId='" + paymentId + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", description='" + description + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
