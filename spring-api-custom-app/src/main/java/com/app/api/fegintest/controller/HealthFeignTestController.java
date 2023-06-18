package com.app.api.fegintest.controller;

import com.app.api.fegintest.client.HelloClient;
import com.app.api.health.dto.HealthCheckResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class HealthFeignTestController {

    private final HelloClient helloClient;

    @GetMapping("/health/feign-test")
    public ResponseEntity<HealthCheckResponse> healthCheckTest() {
        HealthCheckResponse healthCheckResponse = helloClient.healthCheck();
        return ResponseEntity.ok(healthCheckResponse);
    }
}
