package com.hexagonal.crudl.application.service;

import com.hexagonal.crudl.application.query.ObtenerUsuarioPorCedulaQuery;
import com.hexagonal.crudl.domain.exception.UsuarioNoEncontradoException;
import com.hexagonal.crudl.domain.model.Cedula;
import com.hexagonal.crudl.domain.model.Usuario;
import com.hexagonal.crudl.domain.port.in.ObtenerUsuarioPorCedulaUseCase;
import com.hexagonal.crudl.domain.port.out.UsuarioRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class ObtenerUsuarioPorCedulaService implements ObtenerUsuarioPorCedulaUseCase {

    private final UsuarioRepositoryPort repositoryPort;

    public ObtenerUsuarioPorCedulaService(UsuarioRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public Usuario ejecutar(ObtenerUsuarioPorCedulaQuery query) {
        Cedula cedula = new Cedula(query.cedula());

        return repositoryPort.buscarPorCedula(cedula)
                .orElseThrow(() -> new UsuarioNoEncontradoException(query.cedula()));
    }
}
