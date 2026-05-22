package com.hexagonal.crudl.infrastructure.web.dto;

public record ErrorResponse(
        String mensaje,
        String campo
) {}
