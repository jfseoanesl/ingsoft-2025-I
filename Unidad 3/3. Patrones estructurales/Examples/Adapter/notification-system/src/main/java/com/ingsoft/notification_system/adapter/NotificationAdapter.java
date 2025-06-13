package com.ingsoft.notification_system.adapter;


import com.ingsoft.notification_system.model.dto.NotificationRequest;
import com.ingsoft.notification_system.model.dto.NotificationResponse;

public interface NotificationAdapter {
    NotificationResponse send(NotificationRequest request);
    boolean supports(String type);
}
