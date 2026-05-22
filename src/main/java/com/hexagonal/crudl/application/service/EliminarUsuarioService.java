package com.hexagonal.crudl.application.service;

import com.hexagonal.crudl.application.command.EliminarUsuarioCommand;
import com.hexagonal.crudl.domain.exception.UsuarioNoEncontradoException;
import com.hexagonal.crudl.domain.model.Cedula;
import com.hexagonal.crudl.domain.port.in.EliminarUsuarioUseCase;
import com.hexagonal.crudl.domain.port.out.UsuarioRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class EliminarUsuarioService implements EliminarUsuarioUseCase {

    private final UsuarioRepositoryPort repositoryPort;

    public EliminarUsuarioService(UsuarioRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public void ejecutar(EliminarUsuarioCommand comando) {
        Cedula cedula = new Cedula(comando.cedula());

        if (!repositoryPort.existePorCedula(cedula)) {
            throw new UsuarioNoEncontradoException(comando.cedula());
        }

        repositoryPort.eliminar(cedula);
    }
}
