package com.design_pattern.facade.subsystems;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class AuditService {

    public void logTransaction(String orderId, String action, String details) {
        String timestamp = new Date().toString();
        System.out.println("[AUDIT] " + timestamp + " - Order: " + orderId + " - Action: " + action + " - " + details);
        // Lógica compleja de auditoría y compliance
    }

    public void logError(String orderId, String error) {
        String timestamp = new Date().toString();
        System.out.println("[ERROR] " + timestamp + " - Order: " + orderId + " - " + error);
    }
}
