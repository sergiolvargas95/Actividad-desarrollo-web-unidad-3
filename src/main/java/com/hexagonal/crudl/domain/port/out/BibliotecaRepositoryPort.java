package com.hexagonal.crudl.domain.port.out;

import com.hexagonal.crudl.domain.model.Biblioteca;
import com.hexagonal.crudl.domain.model.BibliotecaId;

import java.util.List;
import java.util.Optional;

public interface BibliotecaRepositoryPort {
    Biblioteca guardar(Biblioteca biblioteca);
    Optional<Biblioteca> buscarPorId(BibliotecaId id);
    List<Biblioteca> buscarTodas();
    void eliminar(BibliotecaId id);
    boolean existePorId(BibliotecaId id);
}
