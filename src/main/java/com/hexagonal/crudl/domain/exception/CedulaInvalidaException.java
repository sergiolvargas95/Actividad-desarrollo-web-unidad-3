package com.hexagonal.crudl.domain.exception;

public class CedulaInvalidaException extends RuntimeException {

    public CedulaInvalidaException(String mensaje) {
        super(mensaje);
    }
}
