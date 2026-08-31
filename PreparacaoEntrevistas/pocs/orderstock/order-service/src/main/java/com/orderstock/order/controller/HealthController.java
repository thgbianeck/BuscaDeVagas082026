package com.orderstock.order.controller;

import com.orderstock.order.dto.DependencyHealthResponse;
import com.orderstock.order.dto.HealthResponse;
import com.orderstock.order.exception.InventoryServiceUnavailableException;
import com.orderstock.order.service.InventoryDependencyService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    private final InventoryDependencyService inventoryDependencyService;

    public HealthController(
            InventoryDependencyService inventoryDependencyService
    ) {
        this.inventoryDependencyService = inventoryDependencyService;
    }

    @GetMapping("/api/orders/health")
    public HealthResponse health() {
        return new HealthResponse("order-service", "UP");
    }

    @GetMapping("/api/orders/dependencies/inventory/health")
    public ResponseEntity<DependencyHealthResponse> inventoryHealth() {
        try {
            DependencyHealthResponse response =
                    inventoryDependencyService.checkHealth();

            return ResponseEntity.ok(response);
        } catch (InventoryServiceUnavailableException exception) {
            DependencyHealthResponse response =
                    new DependencyHealthResponse(
                            "inventory-service",
                            "DOWN",
                            "Inventory service is unavailable"
                    );

            return ResponseEntity
                    .status(503)
                    .body(response);
        }
    }
}