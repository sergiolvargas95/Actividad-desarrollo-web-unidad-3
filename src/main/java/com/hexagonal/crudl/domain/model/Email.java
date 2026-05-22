package com.hexagonal.crudl.domain.model;

import com.hexagonal.crudl.domain.exception.EmailInvalidoException;

import java.util.Objects;
import java.util.regex.Pattern;

public final class Email {

    private static final Pattern PATRON_EMAIL =
            Pattern.compile("^[\\w._%+\\-]+@[\\w.\\-]+\\.[a-zA-Z]{2,}$");

    private final String valor;

    public Email(String valor) {
        if (valor != null && !valor.isBlank() && !PATRON_EMAIL.matcher(valor).matches()) {
            throw new EmailInvalidoException("El formato del email no es válido: " + valor);
        }
        this.valor = (valor != null && valor.isBlank()) ? null : valor;
    }

    public String getValor() {
        return valor;
    }

    public boolean estaPresente() {
        return valor != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Email email)) return false;
        return Objects.equals(valor, email.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }

    @Override
    public String toString() {
        return valor != null ? valor : "";
    }
}
