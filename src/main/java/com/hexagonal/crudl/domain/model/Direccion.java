package com.hexagonal.crudl.domain.model;

import com.hexagonal.crudl.domain.exception.BibliotecaInvalidaException;

import java.util.Objects;

public final class Direccion {

    private final String direccion;
    private final String ciudad;
    private final String pais;

    public Direccion(String direccion, String ciudad, String pais) {
        if (direccion == null || direccion.isBlank()) {
            throw new BibliotecaInvalidaException("La dirección no puede estar vacía");
        }
        if (ciudad == null || ciudad.isBlank()) {
            throw new BibliotecaInvalidaException("La ciudad no puede estar vacía");
        }
        if (pais == null || pais.isBlank()) {
            throw new BibliotecaInvalidaException("El país no puede estar vacío");
        }
        this.direccion = direccion.trim();
        this.ciudad = ciudad.trim();
        this.pais = pais.trim();
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getPais() {
        return pais;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Direccion that)) return false;
        return Objects.equals(direccion, that.direccion)
                && Objects.equals(ciudad, that.ciudad)
                && Objects.equals(pais, that.pais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(direccion, ciudad, pais);
    }
}
