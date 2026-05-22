package com.hexagonal.crudl.domain.exception;

public class UsuarioDuplicadoException extends RuntimeException {

    public UsuarioDuplicadoException(String cedula) {
        super("Ya existe un usuario con cédula: " + cedula);
    }
}
