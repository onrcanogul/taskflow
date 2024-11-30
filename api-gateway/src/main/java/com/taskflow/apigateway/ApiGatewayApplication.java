package com.taskflow.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routeConfig(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(x -> x.path("/taskflow/task/**")
						.filters(f -> f.rewritePath("/taskflow/task/(?<segment>.*)", "/${segment}")
								.circuitBreaker(config -> config.setName("taskCircuitBreaker")
										.setFallbackUri("forward:/contactSupport")))
						.uri("lb://TASK"))
				.route(x -> x.path("/taskflow/report/**")
						.filters(f -> f.rewritePath("/taskflow/report/(?<segment>.*)", "/${segment}")
								.circuitBreaker(config -> config.setName("reportCircuitBreaker")
										.setFallbackUri("forward:/contactSupport")))
						.uri("lb://REPORT"))
				.route(x -> x.path("/taskflow/user/**")
						.filters(f -> f.rewritePath("/taskflow/user/(?<segment>.*)", "/${segment}")
								.circuitBreaker(config -> config.setName("userCircuitBreaker")
										.setFallbackUri("forward:/contactSupport")))
						.uri("lb://USER"))
				.route(x -> x.path("/taskflow/notification/**")
				.filters(f -> f.rewritePath("/taskflow/notification/(?<segment>.*)", "/${segment}")
						.circuitBreaker(config -> config.setName("notificationCircuitBreaker")
								.setFallbackUri("forward:/contactSupport")))
				.uri("lb://NOTIFICATION")).build();
	}

}
