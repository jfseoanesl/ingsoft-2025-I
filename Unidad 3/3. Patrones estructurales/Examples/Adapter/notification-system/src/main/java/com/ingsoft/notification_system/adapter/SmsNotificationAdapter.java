package com.ingsoft.notification_system.adapter;

import com.ingsoft.notification_system.external.SmsProvider;
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
public class SmsNotificationAdapter implements NotificationAdapter {

    private final SmsProvider smsProvider;

    @Autowired
    public SmsNotificationAdapter(SmsProvider smsProvider) {
        this.smsProvider = smsProvider;
    }

    @Override
    public NotificationResponse send(NotificationRequest request) {
        log.info("Processing SMS notification through adapter for: {}", request.getRecipient());

        try {
            // Adaptación: convertir la interfaz genérica a la específica del proveedor
            String messageId = smsProvider.sendSms(
                    request.getRecipient(),
                    request.getMessage()
            );

            boolean success = messageId != null;

            return NotificationResponse.builder()
                    .id(success ? messageId : UUID.randomUUID().toString())
                    .status(success ? "SEND" : "FAILED")
                    .message(success ? "SMS notification sent successfully" : "Failed to send SMS notification")
                    .timestamp(LocalDateTime.now())
                    .build();

        } catch (Exception e) {
            log.error("Error sending SMS notification", e);
            return NotificationResponse.builder()
                    .id(UUID.randomUUID().toString())
                    .status("ERROR")
                    .message("Error sending SMS: " + e.getMessage())
                    .timestamp(LocalDateTime.now())
                    .build();
        }
    }

    @Override
    public boolean supports(String type) {
        return NotificationType.SMS.name().equals(type);
    }
}
