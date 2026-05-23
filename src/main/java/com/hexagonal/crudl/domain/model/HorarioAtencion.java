package com.hexagonal.crudl.domain.model;

import com.hexagonal.crudl.domain.exception.BibliotecaInvalidaException;

import java.time.LocalTime;
import java.util.Objects;

public final class HorarioAtencion {

    private final LocalTime apertura;
    private final LocalTime cierre;

    public HorarioAtencion(LocalTime apertura, LocalTime cierre) {
        if (apertura != null && cierre != null && !cierre.isAfter(apertura)) {
            throw new BibliotecaInvalidaException(
                    "El horario de cierre debe ser posterior al de apertura");
        }
        this.apertura = apertura;
        this.cierre = cierre;
    }

    public LocalTime getApertura() {
        return apertura;
    }

    public LocalTime getCierre() {
        return cierre;
    }

    public boolean estaDefinido() {
        return apertura != null && cierre != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HorarioAtencion that)) return false;
        return Objects.equals(apertura, that.apertura)
                && Objects.equals(cierre, that.cierre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apertura, cierre);
    }
}
