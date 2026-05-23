package com.hexagonal.crudl.domain.model;

import com.hexagonal.crudl.domain.exception.BibliotecaInvalidaException;

import java.util.Objects;

public final class BibliotecaId {

    private final Long valor;

    public BibliotecaId(Long valor) {
        if (valor != null && valor <= 0) {
            throw new BibliotecaInvalidaException("El ID de la biblioteca debe ser un número positivo");
        }
        this.valor = valor;
    }

    public Long getValor() {
        return valor;
    }

    public boolean esNuevo() {
        return valor == null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BibliotecaId that)) return false;
        return Objects.equals(valor, that.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }

    @Override
    public String toString() {
        return valor != null ? valor.toString() : "nuevo";
    }
}
