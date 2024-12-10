package com.taskflow.notification.functions;

import com.taskflow.base.events.TaskSendNotificationEvent;
import com.taskflow.notification.dto.NotificationDto;
import com.taskflow.notification.dto.client.UserDto;
import com.taskflow.notification.service.EmailNotificationService;
import com.taskflow.notification.service.client.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private Logger logger = LoggerFactory.getLogger(NotificationFunctions.class);

    @Bean
    public Consumer<TaskSendNotificationEvent> sendEmail() {
        return event -> {
                logger.debug("Email send triggered");
                logger.info("Email send triggered");
                UserDto user = userClient.getById(event.getUserId()).getBody();
                emailService.send(user.getEmail(), event.getTitle(), event.getMessage());
        };
    }
}
