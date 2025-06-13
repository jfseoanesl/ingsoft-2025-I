package com.design_patterns.bridge.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PaymentResponse {
    private String paymentId;
    private String status;
    private BigDecimal amount;
    private String currency;
    private String processor;
    private String message;
    private String details;
    private LocalDateTime processedAt;

    public PaymentResponse() {
        this.processedAt = LocalDateTime.now();
    }

    public PaymentResponse(String paymentId, String status, BigDecimal amount,
                           String currency, String processor, String message, String details) {
        this();
        this.paymentId = paymentId;
        this.status = status;
        this.amount = amount;
        this.currency = currency;
        this.processor = processor;
        this.message = message;
        this.details=details;
    }

    // Getters and Setters
    public String getPaymentId() { return paymentId; }
    public void setPaymentId(String paymentId) { this.paymentId = paymentId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public String getProcessor() { return processor; }
    public void setProcessor(String processor) { this.processor = processor; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public LocalDateTime getProcessedAt() { return processedAt; }
    public void setProcessedAt(LocalDateTime processedAt) { this.processedAt = processedAt; }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
