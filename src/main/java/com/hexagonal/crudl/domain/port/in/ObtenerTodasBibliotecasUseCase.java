package com.hexagonal.crudl.domain.port.in;

import com.hexagonal.crudl.application.query.ObtenerTodasBibliotecasQuery;
import com.hexagonal.crudl.domain.model.Biblioteca;

import java.util.List;

public interface ObtenerTodasBibliotecasUseCase {
    List<Biblioteca> ejecutar(ObtenerTodasBibliotecasQuery query);
}
