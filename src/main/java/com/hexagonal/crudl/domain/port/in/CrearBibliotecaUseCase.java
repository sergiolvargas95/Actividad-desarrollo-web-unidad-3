package com.hexagonal.crudl.domain.port.in;

import com.hexagonal.crudl.application.command.CrearBibliotecaCommand;
import com.hexagonal.crudl.domain.model.Biblioteca;

public interface CrearBibliotecaUseCase {
    Biblioteca ejecutar(CrearBibliotecaCommand comando);
}
