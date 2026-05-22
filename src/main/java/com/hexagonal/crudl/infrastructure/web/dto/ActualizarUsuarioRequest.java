package com.hexagonal.crudl.infrastructure.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ActualizarUsuarioRequest(

        @NotBlank(message = "El password es obligatorio")
        String password,

        @NotBlank(message = "El nombre es obligatorio")
        String nombre,

        @Email(message = "El formato del email no es válido")
        String email
) {}
