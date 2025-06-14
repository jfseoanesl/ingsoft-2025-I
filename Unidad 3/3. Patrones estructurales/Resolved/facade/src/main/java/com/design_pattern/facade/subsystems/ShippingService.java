package com.design_pattern.facade.subsystems;

import com.design_pattern.facade.model.ShippingQuote;
import org.springframework.stereotype.Component;

@Component
public class ShippingService {

    public ShippingQuote calculateShipping(String address, double weight, String method) {
        double cost = 0;
        int days = 0;

        if (method.equals("STANDARD")) {
            cost = weight * 2.5;
            days = 5;
        } else if (method.equals("EXPRESS")) {
            cost = weight * 5.0;
            days = 2;
        } else if (method.equals("OVERNIGHT")) {
            cost = weight * 10.0;
            days = 1;
        }

        // Agregar costo por distancia (simulado)
        if (address.contains("Internacional")) {
            cost *= 3;
            days += 7;
        }

        return new ShippingQuote(cost, days, generateTrackingNumber());
    }

    public void schedulePickup(String address, String trackingNumber) {
        System.out.println("Programando recolección en: " + address + " - Tracking: " + trackingNumber);
    }

    public String getShippingStatus(String trackingNumber) {
        // Simular consulta de estado
        return "En tránsito";
    }

    private String generateTrackingNumber() {
        return "TRK-" + System.currentTimeMillis();
    }
}
