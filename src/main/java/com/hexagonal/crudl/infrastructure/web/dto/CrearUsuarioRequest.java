package com.hexagonal.crudl.infrastructure.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CrearUsuarioRequest(

        @NotBlank(message = "La cédula es obligatoria")
        @Size(max = 15, message = "La cédula no puede superar 15 caracteres")
        String cedula,

        @NotBlank(message = "El password es obligatorio")
        String password,

        @NotBlank(message = "El nombre es obligatorio")
        String nombre,

        @Email(message = "El formato del email no es válido")
        String email
) {}
