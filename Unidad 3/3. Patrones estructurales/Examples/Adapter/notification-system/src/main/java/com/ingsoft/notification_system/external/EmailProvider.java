package com.ingsoft.notification_system.external;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EmailProvider {

    public boolean sendEmail(String to, String subject, String body) {
        log.info("Sending email via EmailProvider to: {} with subject: {}", to, subject);

        // Simulación de lógica específica del proveedor de email
        try {
            Thread.sleep(1000); // Simular latencia de red

            // Lógica específica de API de email (SendGrid, AWS SES, etc.)
            boolean success = Math.random() > 0.1; // 90% success rate

            if (success) {
                log.info("Email sent successfully to: {}", to);
            } else {
                log.error("Failed to send email to: {}", to);
            }

            return success;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Email sending interrupted", e);
            return false;
        }
    }
}
