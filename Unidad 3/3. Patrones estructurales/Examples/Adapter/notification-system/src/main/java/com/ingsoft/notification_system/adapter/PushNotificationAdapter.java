package com.ingsoft.notification_system.adapter;


import com.ingsoft.notification_system.external.PushNotificationProvider;
import com.ingsoft.notification_system.model.dto.NotificationRequest;
import com.ingsoft.notification_system.model.dto.NotificationResponse;
import com.ingsoft.notification_system.model.enums.NotificationType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Component
public class PushNotificationAdapter implements NotificationAdapter {

    private final PushNotificationProvider pushProvider;

    @Autowired
    public PushNotificationAdapter(PushNotificationProvider pushProvider) {
        this.pushProvider = pushProvider;
    }

    @Override
    public NotificationResponse send(NotificationRequest request) {
        log.info("Processing push notification through adapter for device: {}", request.getRecipient());

        try {
            // Adaptación: convertir la interfaz genérica a la específica del proveedor
            Map<String, Object> result = pushProvider.sendPushNotification(
                    request.getRecipient(), // device token
                    request.getSubject() != null ? request.getSubject() : "Notification",
                    request.getMessage(),
                    request.getPriority() != null ? request.getPriority() : "normal"
            );

            boolean success = (Boolean) result.get("success");
            String messageId = (String) result.get("messageId");

            return NotificationResponse.builder()
                    .id(messageId != null ? messageId : UUID.randomUUID().toString())
                    .status(success ? "SENT" : "FAILED")
                    .message(success ? "Push notification sent successfully" : "Failed to send push notification")
                    .timestamp(LocalDateTime.now())
                    .build();

        } catch (Exception e) {
            log.error("Error sending push notification", e);
            return NotificationResponse.builder()
                    .id(UUID.randomUUID().toString())
                    .status("ERROR")
                    .message("Error sending push notification: " + e.getMessage())
                    .timestamp(LocalDateTime.now())
                    .build();
        }
    }

    @Override
    public boolean supports(String type) {
        return NotificationType.PUSH_NOTIFICATION.name().equals(type);
    }
}
