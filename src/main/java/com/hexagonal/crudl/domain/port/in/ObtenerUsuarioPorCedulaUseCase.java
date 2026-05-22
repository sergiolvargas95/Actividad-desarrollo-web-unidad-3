package com.hexagonal.crudl.domain.port.in;

import com.hexagonal.crudl.application.query.ObtenerUsuarioPorCedulaQuery;
import com.hexagonal.crudl.domain.model.Usuario;

public interface ObtenerUsuarioPorCedulaUseCase {
    Usuario ejecutar(ObtenerUsuarioPorCedulaQuery query);
}
