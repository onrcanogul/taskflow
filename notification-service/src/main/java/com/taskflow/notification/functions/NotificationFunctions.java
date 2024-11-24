package com.taskflow.notification.functions;

import com.taskflow.notification.dto.NotificationDto;
import com.taskflow.notification.service.EmailNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class NotificationFunctions {
    @Autowired
    private EmailNotificationService emailService;

    @Bean
    public Consumer<NotificationDto> sendEmail() {
        return notification -> {
            emailService.send(notification.getTo(), notification.getSubject(), notification.getContent());
        };
    }
}
