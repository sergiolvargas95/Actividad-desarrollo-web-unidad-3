package com.hexagonal.crudl.domain.port.in;

import com.hexagonal.crudl.application.command.EliminarUsuarioCommand;

public interface EliminarUsuarioUseCase {
    void ejecutar(EliminarUsuarioCommand comando);
}
