package com.hexagonal.crudl.domain.exception;

public class BibliotecaNoEncontradaException extends RuntimeException {

    public BibliotecaNoEncontradaException(Long id) {
        super("No existe una biblioteca con ID: " + id);
    }
}
