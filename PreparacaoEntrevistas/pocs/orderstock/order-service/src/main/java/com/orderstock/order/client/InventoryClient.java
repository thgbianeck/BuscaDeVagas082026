package com.orderstock.order.client;

import com.orderstock.order.dto.InventoryHealthResponse;
import com.orderstock.order.exception.InventoryServiceUnavailableException;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

@Component
public class InventoryClient {

    private static final String INVENTORY_HEALTH_PATH =
            "/api/inventory/health";

    private final RestClient restClient;

    public InventoryClient(RestClient inventoryRestClient) {
        this.restClient = inventoryRestClient;
    }

    public InventoryHealthResponse getHealth() {
        try {
            InventoryHealthResponse response = restClient.get()
                    .uri(INVENTORY_HEALTH_PATH)
                    .retrieve()
                    .body(InventoryHealthResponse.class);

            if (response == null) {
                throw new InventoryServiceUnavailableException(
                        "Inventory service returned an empty response"
                );
            }

            return response;
        } catch (InventoryServiceUnavailableException exception) {
            throw exception;
        } catch (RestClientException exception) {
            throw new InventoryServiceUnavailableException(
                    "Inventory service is unavailable",
                    exception
            );
        }
    }
}