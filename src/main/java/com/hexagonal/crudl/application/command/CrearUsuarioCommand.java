package com.hexagonal.crudl.application.command;

public record CrearUsuarioCommand(
        String cedula,
        String password,
        String nombre,
        String email
) {}
