package com.hexagonal.crudl.domain.model;

import com.hexagonal.crudl.domain.exception.CedulaInvalidaException;

import java.util.Objects;

public final class Cedula {

    private final String valor;

    public Cedula(String valor) {
        if (valor == null || valor.isBlank()) {
            throw new CedulaInvalidaException("La cédula no puede estar vacía");
        }
        if (valor.length() > 15) {
            throw new CedulaInvalidaException("La cédula no puede superar 15 caracteres");
        }
        this.valor = valor.trim();
    }

    public String getValor() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cedula cedula)) return false;
        return Objects.equals(valor, cedula.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }

    @Override
    public String toString() {
        return valor;
    }
}
