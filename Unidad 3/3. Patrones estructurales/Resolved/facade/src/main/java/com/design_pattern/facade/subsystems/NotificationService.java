package com.design_pattern.facade.subsystems;

import org.springframework.stereotype.Component;

@Component
public class NotificationService {

    public void sendEmail(String email, String subject, String body) {
        System.out.println("Enviando email a: " + email);
        System.out.println("Asunto: " + subject);
        // Lógica compleja de envío de email
    }

    public void sendSMS(String phone, String message) {
        System.out.println("Enviando SMS a: " + phone + " - " + message);
        // Lógica compleja de SMS
    }

    public void sendPushNotification(String userId, String message) {
        System.out.println("Push notification para: " + userId + " - " + message);
        // Lógica compleja de push notifications
    }
}
