package com.hexagonal.crudl.domain.exception;

public class UsuarioNoEncontradoException extends RuntimeException {

    public UsuarioNoEncontradoException(String cedula) {
        super("No existe un usuario con cédula: " + cedula);
    }
}
