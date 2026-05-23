package com.hexagonal.crudl.domain.port.in;

import com.hexagonal.crudl.application.command.ActualizarBibliotecaCommand;
import com.hexagonal.crudl.domain.model.Biblioteca;

public interface ActualizarBibliotecaUseCase {
    Biblioteca ejecutar(ActualizarBibliotecaCommand comando);
}
