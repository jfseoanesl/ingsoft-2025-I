package com.design_pattern.facade.controller;

import com.design_pattern.facade.model.*;
import com.design_pattern.facade.subsystems.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {

    // FALLA 1: El controller conoce TODOS los subsistemas
    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private ShippingService shippingService;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private AuditService auditService;

    @PostMapping("/create")
    public Map<String, Object> createOrder(@RequestBody OrderRequest request) {
        Map<String, Object> response = new HashMap<>();
        String orderId = "ORD-" + System.currentTimeMillis();

        try {
            // FALLA 2: LÓGICA COMPLEJA DIRECTAMENTE EN EL CONTROLLER

            // Paso 1: Verificar inventario
            auditService.logTransaction(orderId, "INVENTORY_CHECK", "Verificando stock para " + request.getProductId());

            if (!inventoryService.checkStock(request.getProductId(), request.getQuantity())) {
                auditService.logError(orderId, "Stock insuficiente");
                response.put("success", false);
                response.put("error", "Stock insuficiente");
                return response;
            }

            // Paso 2: Calcular costos de envío
            auditService.logTransaction(orderId, "SHIPPING_CALC", "Calculando costos de envío");
            ShippingQuote shippingQuote = shippingService.calculateShipping(
                    request.getShippingAddress(),
                    request.getQuantity() * 2.5, // peso estimado
                    request.getShippingMethod()
            );

            // Paso 3: Calcular precio total (simulado)
            double productPrice = 999.99; // Precio simulado
            double totalAmount = (productPrice * request.getQuantity()) + shippingQuote.getCost();

            // Paso 4: Reservar inventario
            auditService.logTransaction(orderId, "INVENTORY_RESERVE", "Reservando " + request.getQuantity() + " unidades");
            inventoryService.reserveStock(request.getProductId(), request.getQuantity());

            // Paso 5: Procesar pago
            auditService.logTransaction(orderId, "PAYMENT_PROCESS", "Procesando pago por $" + totalAmount);
            PaymentResult paymentResult = paymentService.processPayment(
                    request.getPaymentMethod(),
                    totalAmount,
                    request.getCardNumber()
            );

            if (!paymentResult.isSuccess()) {
                // FALLA 3: LÓGICA DE ROLLBACK COMPLEJA Y REPETITIVA
                auditService.logError(orderId, "Fallo en pago: " + paymentResult.getMessage());
                inventoryService.releaseStock(request.getProductId(), request.getQuantity());
                response.put("success", false);
                response.put("error", "Error en pago: " + paymentResult.getMessage());
                return response;
            }

            // Paso 6: Programar envío
            auditService.logTransaction(orderId, "SHIPPING_SCHEDULE", "Programando envío");
            shippingService.schedulePickup(request.getShippingAddress(), shippingQuote.getTrackingNumber());

            // Paso 7: Enviar notificaciones
            auditService.logTransaction(orderId, "NOTIFICATIONS", "Enviando notificaciones");
            notificationService.sendEmail(
                    request.getCustomerEmail(),
                    "Orden Confirmada - " + orderId,
                    "Su orden ha sido procesada exitosamente. Tracking: " + shippingQuote.getTrackingNumber()
            );

            notificationService.sendSMS(
                    request.getCustomerPhone(),
                    "Orden " + orderId + " confirmada. Tracking: " + shippingQuote.getTrackingNumber()
            );

            // FALLA 4: RESPUESTA CON DATOS DE MÚLTIPLES SUBSISTEMAS
            response.put("success", true);
            response.put("orderId", orderId);
            response.put("transactionId", paymentResult.getTransactionId());
            response.put("trackingNumber", shippingQuote.getTrackingNumber());
            response.put("totalAmount", totalAmount);
            response.put("shippingCost", shippingQuote.getCost());
            response.put("estimatedDelivery", shippingQuote.getEstimatedDays() + " días");

            auditService.logTransaction(orderId, "ORDER_COMPLETE", "Orden procesada exitosamente");

        } catch (Exception e) {
            // FALLA 5: MANEJO DE ERRORES COMPLEJO
            auditService.logError(orderId, "Error inesperado: " + e.getMessage());

            // Intentar rollback manual
            try {
                inventoryService.releaseStock(request.getProductId(), request.getQuantity());
            } catch (Exception rollbackError) {
                auditService.logError(orderId, "Error en rollback: " + rollbackError.getMessage());
            }

            response.put("success", false);
            response.put("error", "Error interno del servidor");
        }

        return response;
    }
}
