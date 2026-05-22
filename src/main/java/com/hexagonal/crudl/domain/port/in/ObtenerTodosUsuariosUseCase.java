package com.hexagonal.crudl.domain.port.in;

import com.hexagonal.crudl.application.query.ObtenerTodosUsuariosQuery;
import com.hexagonal.crudl.domain.model.Usuario;

import java.util.List;

public interface ObtenerTodosUsuariosUseCase {
    List<Usuario> ejecutar(ObtenerTodosUsuariosQuery query);
}
