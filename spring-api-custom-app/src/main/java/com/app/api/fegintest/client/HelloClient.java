package com.app.api.fegintest.client;

import com.app.api.health.dto.HealthCheckResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "http://localhost:8080", name = "helloClient")
public interface HelloClient {

    @GetMapping(value = "/api/health", consumes = "application/json")
    HealthCheckResponse healthCheck();
}
