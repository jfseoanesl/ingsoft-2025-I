package com.design_pattern.adapter.paymentSystem.legacy;

import org.springframework.stereotype.Component;

@Component
public class InternalPaymentProcessor  {

    public String processPayment(String customerId, double amount) {

        return "Procesando pago INTERNAMENTE para cliente: " + customerId + ", monto: " + amount;

    }

}
