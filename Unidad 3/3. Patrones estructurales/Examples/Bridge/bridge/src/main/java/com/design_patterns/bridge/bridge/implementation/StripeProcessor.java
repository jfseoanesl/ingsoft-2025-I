package com.design_patterns.bridge.bridge.implementation;

import com.design_patterns.bridge.model.PaymentDetails;
import org.springframework.stereotype.Component;

@Component
public class StripeProcessor implements PaymentProcessor {

    @Override
    public String processPayment(PaymentDetails details) {
        // Simulación de procesamiento con Stripe
        System.out.println("Procesando pago con Stripe...");
        System.out.println("Creando Payment Intent...");
        System.out.println("Confirmando pago...");

        // Simulación de lógica específica de Stripe
        if ("USD".equals(details.getCurrency()) || "EUR".equals(details.getCurrency())) {
            details.setStatus("COMPLETED");
            return "SUCCESS";
        }

        return "CURRENCY_NOT_SUPPORTED";
    }

    @Override
    public String getName() {
        return "Stripe";
    }

    @Override
    public boolean isAvailable() {
        return true;
    }
}
