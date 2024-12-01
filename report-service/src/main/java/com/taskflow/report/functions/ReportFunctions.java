package com.taskflow.report.functions;

import com.taskflow.base.events.TaskCreateReportEvent;
import com.taskflow.base.events.TaskStatusEvent;
import com.taskflow.base.events.UserCreatedEvent;
import com.taskflow.base.exceptions.NotFoundException;
import com.taskflow.report.dto.ReportDto;
import com.taskflow.report.repository.ReportRepository;
import com.taskflow.report.service.ReportService;
import com.taskflow.report.service.client.TaskFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class ReportFunctions {
    @Autowired
    private ReportService service;
    @Autowired
    private ReportRepository repository;
    @Autowired
    private TaskFeignClient taskClient;
    @Bean
    public Consumer<UserCreatedEvent> createUserConsumer() {
        return event -> {
            event.getUserId();
            ReportDto report = new ReportDto();
            report.setUserId(event.getUserId());
            report.setPoints(0);
            report.setLevel(0);
            report.setActiveTasks(0);
            service.create(report);
        };
    }

    @Bean
    public Consumer<TaskCreateReportEvent> createTaskConsumer() {
        return event -> {
            service.handleCreatedTask(repository.findByUserId(event.getUserId())
                    .orElseThrow(() -> new NotFoundException("Report not found")));
        };
    }
    @Bean
    public Consumer<TaskStatusEvent> changeTaskStatusConsumer() {
        return event -> {
            service.handleChangeTaskStatus(repository.findByUserId(event.getUserId())
                    .orElseThrow(() -> new NotFoundException("Report not found")),event.getStatus(), event.getPoints());
            };
        }
}



