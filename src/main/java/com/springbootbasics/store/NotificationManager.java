package com.springbootbasics.store;

import org.springframework.stereotype.Service;

@Service
public class NotificationManager {
    //PROPERTIES:
    private final NotificationService notificationService;

    //CONSTRUCTORS:
    public NotificationManager(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    //METHODS:
    public void sendNotification(String message){
        notificationService.sendMessage(message);
    }
}
