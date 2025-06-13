package com.design_patterns.bridge.bridge.abstraction;

import com.design_patterns.bridge.bridge.implementation.PaymentProcessor;
import com.design_patterns.bridge.model.PaymentDetails;

public class SimplePayment extends Payment {

    public SimplePayment(PaymentProcessor processor) {
        super(processor);
    }

    @Override
    public String processPayment(PaymentDetails details) {
        System.out.println("=== Procesando Pago Simple ===");
        System.out.println("Monto: " + details.getAmount() + " " + details.getCurrency());
        System.out.println("Procesador: " + processor.getName());

        // Validaciones específicas para pago simple
        if (details.getAmount().doubleValue() <= 0) {
            return "INVALID_AMOUNT";
        }

        return executePayment(details);
    }
}
