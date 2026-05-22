package com.hexagonal.crudl.domain.exception;

public class EmailInvalidoException extends RuntimeException {

    public EmailInvalidoException(String mensaje) {
        super(mensaje);
    }
}
