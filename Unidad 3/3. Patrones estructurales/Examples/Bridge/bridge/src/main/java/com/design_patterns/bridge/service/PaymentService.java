package com.design_patterns.bridge.service;

import com.design_patterns.bridge.bridge.abstraction.InstallmentPayment;
import com.design_patterns.bridge.bridge.abstraction.Payment;
import com.design_patterns.bridge.bridge.abstraction.RecurringPayment;
import com.design_patterns.bridge.bridge.abstraction.SimplePayment;
import com.design_patterns.bridge.bridge.implementation.*;
import com.design_patterns.bridge.dto.PaymentRequest;
import com.design_patterns.bridge.dto.PaymentResponse;
import com.design_patterns.bridge.model.PaymentDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
public class PaymentService {

    private final Map<String, PaymentProcessor> processors;

    @Autowired
    public PaymentService(PayPalProcessor payPalProcessor,
                          StripeProcessor stripeProcessor,
                          MercadoPagoProcessor mercadoPagoProcessor,
                          PSEProcessor pseProcessor) {
        this.processors = Map.of(
                "PAYPAL", payPalProcessor,
                "STRIPE", stripeProcessor,
                "MERCADOPAGO", mercadoPagoProcessor,
                "PSE", pseProcessor
        );
    }

    public PaymentResponse processPayment(PaymentRequest request) {
        // Obtener el procesador
        PaymentProcessor processor = processors.get(request.getProcessor().toUpperCase());
        if (processor == null) {
            return new PaymentResponse(null, "ERROR", request.getAmount(),
                    request.getCurrency(), request.getProcessor(), "Procesador no soportado",null);
        }

        // Crear detalles del pago
        PaymentDetails details = new PaymentDetails(
                UUID.randomUUID().toString(),
                request.getAmount(),
                request.getCurrency(),
                request.getDescription(),
                request.getCustomerEmail()
        );

        // Crear el tipo de pago apropiado usando el patrón Bridge
        Payment payment = createPayment(request, processor);

        // Procesar el pago
        String result = payment.processPayment(details);

        // Crear respuesta
        return new PaymentResponse(
                details.getPaymentId(),
                result,
                details.getAmount(),
                details.getCurrency(),
                processor.getName(),
                getMessageForResult(result),
                result
        );
    }

    private Payment createPayment(PaymentRequest request, PaymentProcessor processor) {
        switch (request.getPaymentType().toUpperCase()) {
            case "SIMPLE":
                return new SimplePayment(processor);
            case "INSTALLMENT":
                int installments = request.getInstallments() != null ? request.getInstallments() : 1;
                return new InstallmentPayment(processor, installments);
            case "RECURRING":
                String frequency = request.getFrequency() != null ? request.getFrequency() : "MONTHLY";
                return new RecurringPayment(processor, frequency);
            default:
                return new SimplePayment(processor);
        }
    }

    private String getMessageForResult(String result) {
        return switch (result) {
            case "SUCCESS" -> "Pago procesado exitosamente";
            case "PENDING" -> "Pago pendiente de confirmación";
            case "REQUIRES_VERIFICATION" -> "Pago requiere verificación adicional";
            case "CURRENCY_NOT_SUPPORTED" -> "Moneda no soportada por este procesador";
            case "INVALID_AMOUNT" -> "Monto inválido";
            case "INVALID_INSTALLMENTS" -> "Número de cuotas inválido (2-24)";
            case "MINIMUM_AMOUNT_FOR_INSTALLMENTS" -> "Monto mínimo para cuotas: 100";
            case "INVALID_FREQUENCY" -> "Frecuencia inválida (MONTHLY, WEEKLY, YEARLY)";
            case "MINIMUM_AMOUNT_FOR_RECURRING" -> "Monto mínimo para pagos recurrentes: 10";
            default -> "Error en el procesamiento del pago";
        };
    }
}
