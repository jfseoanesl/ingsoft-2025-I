package com.ingsoft.notification_system.service;

import com.ingsoft.notification_system.model.dto.NotificationRequest;
import com.ingsoft.notification_system.model.dto.NotificationResponse;

import java.util.List;

public interface NotificationService {
    NotificationResponse sendNotification(NotificationRequest request);
    List<NotificationResponse> sendBulkNotifications(List<NotificationRequest> requests);
}