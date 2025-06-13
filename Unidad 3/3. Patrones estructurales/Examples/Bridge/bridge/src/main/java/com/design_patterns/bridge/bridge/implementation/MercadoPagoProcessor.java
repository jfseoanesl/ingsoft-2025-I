package com.design_patterns.bridge.bridge.implementation;

import com.design_patterns.bridge.model.PaymentDetails;
import org.springframework.stereotype.Component;

@Component
public class MercadoPagoProcessor implements PaymentProcessor {

    @Override
    public String processPayment(PaymentDetails details) {
        // Simulación de procesamiento con MercadoPago
        System.out.println("Procesando pago con MercadoPago...");
        System.out.println("Validando con sistema bancario local...");

        // Simulación de lógica específica de MercadoPago
        if ("COP".equals(details.getCurrency()) || "ARS".equals(details.getCurrency())) {
            details.setStatus("COMPLETED");
            return "SUCCESS";
        }

        return "CURRENCY_NOT_SUPPORTED";
    }

    @Override
    public String getName() {
        return "MercadoPago";
    }

    @Override
    public boolean isAvailable() {
        return true;
    }
}
