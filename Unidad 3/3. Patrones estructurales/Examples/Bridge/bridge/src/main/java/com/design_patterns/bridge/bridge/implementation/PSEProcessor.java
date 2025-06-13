package com.design_patterns.bridge.bridge.implementation;

import com.design_patterns.bridge.model.PaymentDetails;
import org.springframework.stereotype.Component;

@Component
public class PSEProcessor implements PaymentProcessor {

    @Override
    public String processPayment(PaymentDetails details) {
        // Simulación de procesamiento con PSE
        System.out.println("Procesando pago con PSE...");
        System.out.println("Redirigiendo a banco seleccionado...");

        // Simulación de lógica específica de PSE
        if ("COP".equals(details.getCurrency())) {
            details.setStatus("PENDING_BANK_CONFIRMATION");
            return "PENDING";
        }

        return "CURRENCY_NOT_SUPPORTED";
    }

    @Override
    public String getName() {
        return "PSE";
    }

    @Override
    public boolean isAvailable() {
        return true;
    }
}
