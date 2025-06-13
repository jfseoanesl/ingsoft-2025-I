package com.design_patterns.bridge.bridge.implementation;

import com.design_patterns.bridge.model.PaymentDetails;
import org.springframework.stereotype.Component;

@Component
public class PayPalProcessor implements PaymentProcessor {

    @Override
    public String processPayment(PaymentDetails details) {
        // Simulación de procesamiento con PayPal
        System.out.println("Procesando pago con PayPal...");
        System.out.println("Conectando a PayPal API...");
        System.out.println("Validando credenciales...");

        // Simulación de lógica específica de PayPal
        if (details.getAmount().doubleValue() > 10000) {
            return "REQUIRES_VERIFICATION";
        }

        details.setStatus("COMPLETED");
        return "SUCCESS";
    }

    @Override
    public String getName() {
        return "PayPal";
    }

    @Override
    public boolean isAvailable() {
        return true; // Simulación de disponibilidad
    }
}
