package com.design_patterns.bridge.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class PaymentRequest {
    @NotNull(message = "El monto es requerido")
    @DecimalMin(value = "0.01", message = "El monto debe ser mayor a 0")
    private BigDecimal amount;

    @NotBlank(message = "La moneda es requerida")
    private String currency;

    @NotBlank(message = "La descripción es requerida")
    private String description;

    @Email(message = "Email inválido")
    @NotBlank(message = "El email del cliente es requerido")
    private String customerEmail;

    @NotBlank(message = "El tipo de pago es requerido")
    private String paymentType;

    @NotBlank(message = "El procesador de pago es requerido")
    private String processor;

    private Integer installments;
    private String frequency;

    // Constructors
    public PaymentRequest() {}

    // Getters and Setters
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getCustomerEmail() { return customerEmail; }
    public void setCustomerEmail(String customerEmail) { this.customerEmail = customerEmail; }

    public String getPaymentType() { return paymentType; }
    public void setPaymentType(String paymentType) { this.paymentType = paymentType; }

    public String getProcessor() { return processor; }
    public void setProcessor(String processor) { this.processor = processor; }

    public Integer getInstallments() { return installments; }
    public void setInstallments(Integer installments) { this.installments = installments; }

    public String getFrequency() { return frequency; }
    public void setFrequency(String frequency) { this.frequency = frequency; }
}
