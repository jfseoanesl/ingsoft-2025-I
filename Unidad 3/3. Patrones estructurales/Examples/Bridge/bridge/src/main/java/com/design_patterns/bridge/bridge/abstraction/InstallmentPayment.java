package com.design_patterns.bridge.bridge.abstraction;

import com.design_patterns.bridge.bridge.implementation.PaymentProcessor;
import com.design_patterns.bridge.model.PaymentDetails;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class InstallmentPayment extends Payment {
    private int installments;

    public InstallmentPayment(PaymentProcessor processor, int installments) {
        super(processor);
        this.installments = installments;
    }

    @Override
    public String processPayment(PaymentDetails details) {
        System.out.println("=== Procesando Pago con Cuotas ===");
        System.out.println("Monto total: " + details.getAmount() + " " + details.getCurrency());
        System.out.println("Número de cuotas: " + installments);
        System.out.println("Procesador: " + processor.getName());

        // Cálculo del monto por cuota
        BigDecimal installmentAmount = details.getAmount()
                .divide(BigDecimal.valueOf(installments), 2, RoundingMode.HALF_UP);
        System.out.println("Monto por cuota: " + installmentAmount + " " + details.getCurrency());

        // Validaciones específicas para pago con cuotas
        if (installments < 2 || installments > 24) {
            return "INVALID_INSTALLMENTS";
        }

        if (details.getAmount().doubleValue() < 100) {
            return "MINIMUM_AMOUNT_FOR_INSTALLMENTS";
        }

        return executePayment(details);
    }

    public int getInstallments() {
        return installments;
    }
}
