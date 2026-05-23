package com.hexagonal.crudl.application.command;

import java.time.LocalTime;

public record ActualizarBibliotecaCommand(
        Long id,
        String nombre,
        String direccion,
        String ciudad,
        String pais,
        String telefono,
        String email,
        LocalTime horarioApertura,
        LocalTime horarioCierre,
        Integer numLibros,
        Integer numUsuarios,
        boolean esPublica,
        String web
) {}
