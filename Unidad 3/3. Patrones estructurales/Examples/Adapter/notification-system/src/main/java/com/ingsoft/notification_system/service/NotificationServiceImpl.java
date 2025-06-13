package com.ingsoft.notification_system.service;

import com.ingsoft.notification_system.adapter.NotificationAdapter;
import com.ingsoft.notification_system.exception.NotificationException;
import com.ingsoft.notification_system.model.dto.NotificationRequest;
import com.ingsoft.notification_system.model.dto.NotificationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@Slf4j
@Service
public class NotificationServiceImpl implements NotificationService {

    private final List<NotificationAdapter> notificationAdapters;
    private final ExecutorService executorService;

    @Autowired
    public NotificationServiceImpl(List<NotificationAdapter> notificationAdapters) {
        this.notificationAdapters = notificationAdapters;
        this.executorService = Executors.newFixedThreadPool(10);
    }

    @Override
    public NotificationResponse sendNotification(NotificationRequest request) {
        log.info("Processing notification request for type: {} and recipient: {}",
                request.getType(), request.getRecipient());

        NotificationAdapter adapter = findAdapter(request.getType().name());

        if (adapter == null) {
            throw new NotificationException("No adapter found for notification type: " + request.getType());
        }

        return adapter.send(request);
    }

    @Override
    public List<NotificationResponse> sendBulkNotifications(List<NotificationRequest> requests) {
        log.info("Processing bulk notification requests. Count: {}", requests.size());

        List<CompletableFuture<NotificationResponse>> futures = requests.stream()
                .map(request -> CompletableFuture.supplyAsync(() -> sendNotification(request), executorService))
                .toList();

        return futures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }

    private NotificationAdapter findAdapter(String type) {
        return notificationAdapters.stream()
                .filter(adapter -> adapter.supports(type))
                .findFirst()
                .orElse(null);
    }
}
