package com.hexagonal.crudl.domain.port.in;

import com.hexagonal.crudl.application.command.EliminarBibliotecaCommand;

public interface EliminarBibliotecaUseCase {
    void ejecutar(EliminarBibliotecaCommand comando);
}
