package com.hexagonal.crudl.infrastructure.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.time.LocalTime;

public record CrearBibliotecaRequest(

        @NotBlank(message = "El nombre es obligatorio")
        @Size(max = 100, message = "El nombre no puede superar 100 caracteres")
        String nombre,

        @NotBlank(message = "La dirección es obligatoria")
        @Size(max = 200, message = "La dirección no puede superar 200 caracteres")
        String direccion,

        @NotBlank(message = "La ciudad es obligatoria")
        @Size(max = 100, message = "La ciudad no puede superar 100 caracteres")
        String ciudad,

        @NotBlank(message = "El país es obligatorio")
        @Size(max = 100, message = "El país no puede superar 100 caracteres")
        String pais,

        @Size(max = 20, message = "El teléfono no puede superar 20 caracteres")
        String telefono,

        @Email(message = "El formato del email no es válido")
        @Size(max = 100, message = "El email no puede superar 100 caracteres")
        String email,

        @JsonFormat(pattern = "HH:mm:ss")
        LocalTime horarioApertura,

        @JsonFormat(pattern = "HH:mm:ss")
        LocalTime horarioCierre,

        @PositiveOrZero(message = "El número de libros no puede ser negativo")
        Integer numLibros,

        @PositiveOrZero(message = "El número de usuarios no puede ser negativo")
        Integer numUsuarios,

        boolean esPublica,

        @Size(max = 200, message = "La web no puede superar 200 caracteres")
        String web
) {}
