package com.design_pattern.facade.subsystems;

import com.design_pattern.facade.model.PaymentResult;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {

    public PaymentResult processPayment(String paymentMethod, double amount, String cardNumber) {
        // Simular procesamiento complejo
        try {
            Thread.sleep(1000); // Simular latencia

            if (paymentMethod.equals("CREDIT_CARD")) {
                return processCreditCard(cardNumber, amount);
            } else if (paymentMethod.equals("PAYPAL")) {
                return processPayPal(amount);
            } else if (paymentMethod.equals("BANK_TRANSFER")) {
                return processBankTransfer(amount);
            }

            return new PaymentResult(false, "Método de pago no soportado", null);

        } catch (InterruptedException e) {
            return new PaymentResult(false, "Error en procesamiento", null);
        }
    }

    private PaymentResult processCreditCard(String cardNumber, double amount) {
        if (cardNumber.length() != 16) {
            return new PaymentResult(false, "Número de tarjeta inválido", null);
        }
        String transactionId = "CC-" + System.currentTimeMillis();
        return new PaymentResult(true, "Pago exitoso", transactionId);
    }

    private PaymentResult processPayPal(double amount) {
        if (amount > 5000) {
            return new PaymentResult(false, "Monto excede límite PayPal", null);
        }
        String transactionId = "PP-" + System.currentTimeMillis();
        return new PaymentResult(true, "Pago PayPal exitoso", transactionId);
    }

    private PaymentResult processBankTransfer(double amount) {
        String transactionId = "BT-" + System.currentTimeMillis();
        return new PaymentResult(true, "Transferencia iniciada", transactionId);
    }

    public void refundPayment(String transactionId) {
        // Lógica compleja de reembolso
        System.out.println("Procesando reembolso para: " + transactionId);
    }
}
