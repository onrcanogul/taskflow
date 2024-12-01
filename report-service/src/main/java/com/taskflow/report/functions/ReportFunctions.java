package com.taskflow.report.functions;


import com.taskflow.base.enums.TaskStatus;
import com.taskflow.base.events.TaskCreateReportEvent;
import com.taskflow.base.events.TaskStatusEvent;
import com.taskflow.base.events.UserCreatedEvent;
import com.taskflow.report.dto.ReportDto;
import com.taskflow.report.entity.Report;
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
            Report report = repository.findByUserId(event.getUserId());
            report.setCompletedTasks(report.getCompletedTasks() + 1);
            report.setActiveTasks(report.getActiveTasks() - 1);
            repository.save(report);
        };
    }

    @Bean
    public Consumer<TaskStatusEvent> changeTaskStatusConsumer() {
        return event -> {
            Report report = repository.findByUserId(event.getUserId());
            if(event.getStatus() == TaskStatus.Done) {
                report.setCompletedTasks(report.getCompletedTasks() + 1);
                report.setActiveTasks(report.getActiveTasks() - 1);
                report.setPoints(report.getPoints() + event.getPoints());
                repository.save(report);
            }
        };
    }

}
