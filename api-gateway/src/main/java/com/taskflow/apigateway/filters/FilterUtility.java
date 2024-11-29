package com.taskflow.apigateway.filters;


import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.List;

@Component
public class FilterUtility {
    public static final String CORRELATION_ID = "correlation-id";

    public String getCorrelationId(HttpHeaders requestHeaders) {
        if(requestHeaders.get(CORRELATION_ID) != null) {
            List<String> correlationIds = requestHeaders.get(CORRELATION_ID);
            return correlationIds.stream().findFirst().get();
        }
        return null;
    }

    public ServerWebExchange setCorrelationId(ServerWebExchange exchange, String correlationId) {
        return exchange.mutate()
                .request(exchange.getRequest().mutate()
                        .header(FilterUtility.CORRELATION_ID, correlationId)
                        .build())
                .build();
    }
}
