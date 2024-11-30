package com.taskflow.report.functions;


import com.taskflow.base.events.TaskCreateReportEvent;
import com.taskflow.report.dto.ReportDto;
import com.taskflow.report.dto.client.TaskDto;
import com.taskflow.report.service.ReportService;
import com.taskflow.report.service.client.TaskFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.function.Consumer;

@Configuration
public class ReportFunctions {
    @Autowired
    private ReportService service;
    @Autowired
    private TaskFeignClient taskClient;
    @Bean
    public Consumer<TaskCreateReportEvent> createReportConsumer() {
        return event -> {
            List<TaskDto> dto = taskClient.getCompleted(event.getUserId()).getBody();
            ReportDto report = new ReportDto();
            report.setCompletedTasks(dto.size());
        };
    }

}
