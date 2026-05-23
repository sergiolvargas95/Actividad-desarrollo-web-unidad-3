package com.hexagonal.crudl.domain.port.in;

import com.hexagonal.crudl.application.query.ObtenerBibliotecaPorIdQuery;
import com.hexagonal.crudl.domain.model.Biblioteca;

public interface ObtenerBibliotecaPorIdUseCase {
    Biblioteca ejecutar(ObtenerBibliotecaPorIdQuery query);
}
