package com.orderstock.order.service;

import com.orderstock.order.client.InventoryClient;
import com.orderstock.order.dto.DependencyHealthResponse;
import com.orderstock.order.dto.InventoryHealthResponse;

import org.springframework.stereotype.Service;

@Service
public class InventoryDependencyService {

    private final InventoryClient inventoryClient;

    public InventoryDependencyService(InventoryClient inventoryClient) {
        this.inventoryClient = inventoryClient;
    }

    public DependencyHealthResponse checkHealth() {
        InventoryHealthResponse inventoryHealth =
                inventoryClient.getHealth();

        return new DependencyHealthResponse(
                inventoryHealth.service(),
                inventoryHealth.status(),
                null
        );
    }
}