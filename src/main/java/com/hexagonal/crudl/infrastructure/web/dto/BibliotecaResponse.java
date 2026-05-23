package com.hexagonal.crudl.infrastructure.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalTime;

public record BibliotecaResponse(
        Long id,
        String nombre,
        String direccion,
        String ciudad,
        String pais,
        String telefono,
        String email,
        @JsonFormat(pattern = "HH:mm:ss") LocalTime horarioApertura,
        @JsonFormat(pattern = "HH:mm:ss") LocalTime horarioCierre,
        Integer numLibros,
        Integer numUsuarios,
        boolean esPublica,
        String web
) {}
