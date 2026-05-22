package com.hexagonal.crudl.domain.port.in;

import com.hexagonal.crudl.application.command.CrearUsuarioCommand;
import com.hexagonal.crudl.domain.model.Usuario;

public interface CrearUsuarioUseCase {
    Usuario ejecutar(CrearUsuarioCommand comando);
}
