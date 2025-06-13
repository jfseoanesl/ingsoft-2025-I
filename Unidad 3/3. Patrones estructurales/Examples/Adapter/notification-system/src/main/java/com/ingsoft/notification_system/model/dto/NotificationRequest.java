package com.ingsoft.notification_system.model.dto;


import com.ingsoft.notification_system.model.enums.NotificationType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationRequest {

    @NotNull(message = "Notification type is required")
    private NotificationType type;

    @NotBlank(message = "Recipient is required")
    private String recipient;

    @NotBlank(message = "Message is required")
    private String message;

    private String subject;
    private String priority;
}
