package com.ingsoft.notification_system.adapter;


import com.ingsoft.notification_system.external.EmailProvider;
import com.ingsoft.notification_system.model.dto.NotificationRequest;
import com.ingsoft.notification_system.model.dto.NotificationResponse;
import com.ingsoft.notification_system.model.enums.NotificationType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Component
public class EmailNotificationAdapter implements NotificationAdapter {

    private final EmailProvider emailProvider;

    @Autowired
    public EmailNotificationAdapter(EmailProvider emailProvider) {

        this.emailProvider = emailProvider;
    }

    @Override
    public NotificationResponse send(NotificationRequest request) {
        log.info("Processing email notification through adapter for: {}", request.getRecipient());

        try {
            // Adaptación: convertir la interfaz genérica a la específica del proveedor
            boolean success = emailProvider.sendEmail(
                    request.getRecipient(),
                    request.getSubject() != null ? request.getSubject() : "Notification",
                    request.getMessage()
            );

            return NotificationResponse.builder()
                    .id(UUID.randomUUID().toString())
                    .status(success ? "SEND" : "FAILED")
                    .message(success ? "Email notification sent successfully" : "Failed to send email notification")
                    .timestamp(LocalDateTime.now())
                    .build();

        } catch (Exception e) {
            log.error("Error sending email notification", e);
            return NotificationResponse.builder()
                    .id(UUID.randomUUID().toString())
                    .status("ERROR")
                    .message("Error sending email: " + e.getMessage())
                    .timestamp(LocalDateTime.now())
                    .build();
        }
    }

    @Override
    public boolean supports(String type) {

        return NotificationType.EMAIL.name().equals(type);
    }
}
