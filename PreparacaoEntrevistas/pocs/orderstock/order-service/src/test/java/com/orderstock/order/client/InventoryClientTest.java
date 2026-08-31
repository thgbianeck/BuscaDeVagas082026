package com.orderstock.order.client;

import com.orderstock.order.dto.InventoryHealthResponse;
import com.orderstock.order.exception.InventoryServiceUnavailableException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InventoryClientTest {

    @Mock
    private RestClient restClient;

    @Mock
    private RestClient.RequestHeadersUriSpec<?> requestHeadersUriSpec;

    @Mock
    private RestClient.RequestHeadersSpec<?> requestHeadersSpec;

    @Mock
    private RestClient.ResponseSpec responseSpec;

    private InventoryClient inventoryClient;

    @BeforeEach
    void setUp() {
        inventoryClient = new InventoryClient(restClient);

        // Erro encontrado: Cannot resolve method 'thenReturn(RequestHeadersUriSpec<capture of ?>)'
        when(restClient.get()).thenReturn(requestHeadersUriSpec);

        // Erro encontrado: Cannot resolve method 'thenReturn(RequestHeadersSpec<capture of ?>)'
        when(requestHeadersUriSpec.uri("/api/inventory/health")).thenReturn(requestHeadersSpec);

        when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);
    }

    @Test
    void shouldReturnInventoryHealthWhenRequestSucceeds() {
        InventoryHealthResponse expectedResponse =
                new InventoryHealthResponse(
                        "inventory-service",
                        "UP"
                );

        when(responseSpec.body(InventoryHealthResponse.class))
                .thenReturn(expectedResponse);

        InventoryHealthResponse actualResponse =
                inventoryClient.getHealth();

        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void shouldThrowControlledExceptionWhenInventoryIsUnavailable() {
        when(responseSpec.body(InventoryHealthResponse.class))
                .thenThrow(
                        new RestClientException(
                                "Connection refused"
                        )
                );

        assertThrows(
                InventoryServiceUnavailableException.class,
                () -> inventoryClient.getHealth()
        );
    }

    @Test
    void shouldThrowControlledExceptionWhenInventoryReturnsServerError() {
        HttpServerErrorException serverError =
                HttpServerErrorException.create(
                        HttpStatus.INTERNAL_SERVER_ERROR,
                        "Internal Server Error",
                        HttpHeaders.EMPTY,
                        new byte[0],
                        StandardCharsets.UTF_8
                );

        when(responseSpec.body(InventoryHealthResponse.class))
                .thenThrow(serverError);

        assertThrows(
                InventoryServiceUnavailableException.class,
                () -> inventoryClient.getHealth()
        );
    }

    @Test
    void shouldThrowControlledExceptionWhenResponseIsEmpty() {
        when(responseSpec.body(InventoryHealthResponse.class))
                .thenReturn(null);

        assertThrows(
                InventoryServiceUnavailableException.class,
                () -> inventoryClient.getHealth()
        );
    }
}