package com.hexagonal.crudl.infrastructure.web.dto;

public record UsuarioResponse(
        String cedula,
        String nombre,
        String email
) {}
