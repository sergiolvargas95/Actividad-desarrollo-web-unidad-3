package com.hexagonal.crudl.domain.exception;

public class BibliotecaInvalidaException extends RuntimeException {

    public BibliotecaInvalidaException(String mensaje) {
        super(mensaje);
    }
}
