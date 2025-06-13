package com.ingsoft.notification_system.controller;

import com.ingsoft.notification_system.model.dto.NotificationRequest;
import com.ingsoft.notification_system.model.dto.NotificationResponse;
import com.ingsoft.notification_system.service.NotificationService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/notifications")
@CrossOrigin(origins = "*")
public class NotificationController {

    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/send")
    public ResponseEntity<NotificationResponse> sendNotification(
            @Valid @RequestBody NotificationRequest request) {

        log.info("Received notification request: {}", request);

        NotificationResponse response = notificationService.sendNotification(request);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/send-bulk")
    public ResponseEntity<List<NotificationResponse>> sendBulkNotifications(
            @Valid @RequestBody List<NotificationRequest> requests) {

        log.info("Received bulk notification request with {} notifications", requests.size());

        List<NotificationResponse> responses = notificationService.sendBulkNotifications(requests);

        return ResponseEntity.ok(responses);
    }

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Notification service is running");
    }
}
