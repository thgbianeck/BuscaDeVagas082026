package com.orderstock.order.controller;

import com.orderstock.order.dto.DependencyHealthResponse;
import com.orderstock.order.exception.InventoryServiceUnavailableException;
import com.orderstock.order.service.InventoryDependencyService;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// Erro encontrado: 'org.springframework.boot.test.mock.mockito.MockBean' is deprecated since version 3.4.0 and marked for removal
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HealthController.class)
class HealthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InventoryDependencyService inventoryDependencyService;

    @Test
    void shouldReturnOrderServiceHealth() throws Exception {
        mockMvc.perform(get("/api/orders/health"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.service")
                        .value("order-service"))
                .andExpect(jsonPath("$.status")
                        .value("UP"));
    }

    @Test
    void shouldReturnInventoryDependencyHealth() throws Exception {
        when(inventoryDependencyService.checkHealth())
                .thenReturn(
                        new DependencyHealthResponse(
                                "inventory-service",
                                "UP",
                                null
                        )
                );

        mockMvc.perform(
                        get("/api/orders/dependencies/inventory/health")
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.dependency")
                        .value("inventory-service"))
                .andExpect(jsonPath("$.status")
                        .value("UP"));
    }

    @Test
    void shouldReturnServiceUnavailableWhenInventoryIsDown()
            throws Exception {

        when(inventoryDependencyService.checkHealth())
                .thenThrow(
                        new InventoryServiceUnavailableException(
                                "Inventory service is unavailable"
                        )
                );

        mockMvc.perform(
                        get("/api/orders/dependencies/inventory/health")
                )
                .andExpect(status().isServiceUnavailable())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.dependency")
                        .value("inventory-service"))
                .andExpect(jsonPath("$.status")
                        .value("DOWN"))
                .andExpect(jsonPath("$.message")
                        .value("Inventory service is unavailable"));
    }
}