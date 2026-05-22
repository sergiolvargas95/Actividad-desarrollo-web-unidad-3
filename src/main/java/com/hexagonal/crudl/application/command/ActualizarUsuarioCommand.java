package com.hexagonal.crudl.application.command;

public record ActualizarUsuarioCommand(
        String cedula,
        String password,
        String nombre,
        String email
) {}
