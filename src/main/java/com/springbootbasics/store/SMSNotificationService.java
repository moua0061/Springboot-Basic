package com.springbootbasics.store;

import org.springframework.stereotype.Service;

@Service
public class SMSNotificationService implements  NotificationService{
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending SMS: " + message);
    }
}
