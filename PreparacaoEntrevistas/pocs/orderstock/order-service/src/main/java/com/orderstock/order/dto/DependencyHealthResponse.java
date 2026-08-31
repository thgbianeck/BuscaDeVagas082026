package com.orderstock.order.dto;

public record DependencyHealthResponse(
        String dependency,
        String status,
        String message
) {
}