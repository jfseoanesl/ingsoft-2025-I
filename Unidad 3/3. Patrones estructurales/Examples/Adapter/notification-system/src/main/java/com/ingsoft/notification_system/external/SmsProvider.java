package com.ingsoft.notification_system.external;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SmsProvider {

    public String sendSms(String phoneNumber, String message) {
        log.info("Sending SMS via SmsProvider to: {}", phoneNumber);

        // Simulación de lógica específica del proveedor de SMS
        try {
            Thread.sleep(500); // Simular latencia de red

            // Lógica específica de API de SMS (Twilio, AWS SNS, etc.)
            boolean success = Math.random() > 0.05; // 95% success rate
            String messageId = "SMS_" + System.currentTimeMillis();

            if (success) {
                log.info("SMS sent successfully to: {} with ID: {}", phoneNumber, messageId);
                return messageId;
            } else {
                log.error("Failed to send SMS to: {}", phoneNumber);
                return null;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("SMS sending interrupted", e);
            return null;
        }
    }
}
