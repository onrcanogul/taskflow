package com.taskflow.notification.functions;

import com.taskflow.base.events.TaskSendNotificationEvent;
import com.taskflow.notification.dto.NotificationDto;
import com.taskflow.notification.dto.client.UserDto;
import com.taskflow.notification.service.EmailNotificationService;
import com.taskflow.notification.service.client.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class NotificationFunctions {
    @Autowired
    private EmailNotificationService emailService;
    @Autowired
    private UserFeignClient userClient;

    @Bean
    public Consumer<TaskSendNotificationEvent> sendEmail() {
        return event -> {
            UserDto user = userClient.getById(event.getUserId()).getBody();
            emailService.send(user.getEmail(), event.getTitle(), event.getMessage());
        };
    }



}
