package com.springbootbasics.store;

public interface NotificationService {
    //void sendMessage(String message);

    void send(String message, String recipientEmail);
}
