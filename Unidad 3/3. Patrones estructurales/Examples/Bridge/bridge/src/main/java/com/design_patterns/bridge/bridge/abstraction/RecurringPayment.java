package com.design_patterns.bridge.bridge.abstraction;

import com.design_patterns.bridge.bridge.implementation.PaymentProcessor;
import com.design_patterns.bridge.model.PaymentDetails;

public class RecurringPayment extends Payment {
    private String frequency; // MONTHLY, WEEKLY, YEARLY

    public RecurringPayment(PaymentProcessor processor, String frequency) {
        super(processor);
        this.frequency = frequency;
    }

    @Override
    public String processPayment(PaymentDetails details) {
        System.out.println("=== Procesando Pago Recurrente ===");
        System.out.println("Monto: " + details.getAmount() + " " + details.getCurrency());
        System.out.println("Frecuencia: " + frequency);
        System.out.println("Procesador: " + processor.getName());

        // Validaciones específicas para pago recurrente
        if (!isValidFrequency(frequency)) {
            return "INVALID_FREQUENCY";
        }

        if (details.getAmount().doubleValue() < 10) {
            return "MINIMUM_AMOUNT_FOR_RECURRING";
        }

        // Configurar como pago recurrente
        details.setDescription(details.getDescription() + " - Pago recurrente " + frequency);

        return executePayment(details);
    }

    private boolean isValidFrequency(String frequency) {
        return "MONTHLY".equals(frequency) || "WEEKLY".equals(frequency) || "YEARLY".equals(frequency);
    }

    public String getFrequency() {
        return frequency;
    }
}
