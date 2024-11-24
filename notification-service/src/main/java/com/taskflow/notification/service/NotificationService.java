package com.taskflow.notification.service;

public interface NotificationService {
    void send(String to, String subject, String content);
}
