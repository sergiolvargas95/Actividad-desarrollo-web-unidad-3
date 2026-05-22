package com.hexagonal.crudl.domain.port.in;

import com.hexagonal.crudl.application.command.ActualizarUsuarioCommand;
import com.hexagonal.crudl.domain.model.Usuario;

public interface ActualizarUsuarioUseCase {
    Usuario ejecutar(ActualizarUsuarioCommand comando);
}
