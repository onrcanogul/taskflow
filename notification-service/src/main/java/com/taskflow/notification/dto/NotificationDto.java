package com.taskflow.notification.dto;

import lombok.Data;

@Data
public class NotificationDto {
    private String sendTo;
    private String subject;
    private String content;
}
