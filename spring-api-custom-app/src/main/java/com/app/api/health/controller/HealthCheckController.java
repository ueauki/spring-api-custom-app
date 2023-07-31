package com.app.api.health.controller;

import com.app.api.health.dto.HealthCheckResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class HealthCheckController {

    private final Environment environment;

    @GetMapping("/health")
    public ResponseEntity<HealthCheckResponse> healthCheck() {

//        try {
//            Thread.sleep(6000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        HealthCheckResponse healthCheckResponse = HealthCheckResponse.builder()
                .health("ok")
                .activeProfiles(Arrays.asList(environment.getActiveProfiles()))
                .build();
        return ResponseEntity.ok(healthCheckResponse);
    }

}
