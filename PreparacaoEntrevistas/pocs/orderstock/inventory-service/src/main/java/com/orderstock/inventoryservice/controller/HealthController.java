package com.orderstock.inventoryservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class HealthController {

    @GetMapping("/api/inventory/health")
    public HealthResponse health() {
        return new HealthResponse("inventory-service", "UP", LocalDateTime.now().toString());
    }
}