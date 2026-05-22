package com.hexagonal.crudl.application.service;

import com.hexagonal.crudl.application.query.ObtenerTodosUsuariosQuery;
import com.hexagonal.crudl.domain.model.Usuario;
import com.hexagonal.crudl.domain.port.in.ObtenerTodosUsuariosUseCase;
import com.hexagonal.crudl.domain.port.out.UsuarioRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObtenerTodosUsuariosService implements ObtenerTodosUsuariosUseCase {

    private final UsuarioRepositoryPort repositoryPort;

    public ObtenerTodosUsuariosService(UsuarioRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public List<Usuario> ejecutar(ObtenerTodosUsuariosQuery query) {
        return repositoryPort.buscarTodos();
    }
}
