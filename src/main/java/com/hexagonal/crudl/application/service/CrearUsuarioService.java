package com.hexagonal.crudl.application.service;

import com.hexagonal.crudl.application.command.CrearUsuarioCommand;
import com.hexagonal.crudl.domain.exception.UsuarioDuplicadoException;
import com.hexagonal.crudl.domain.model.Cedula;
import com.hexagonal.crudl.domain.model.Email;
import com.hexagonal.crudl.domain.model.Usuario;
import com.hexagonal.crudl.domain.port.in.CrearUsuarioUseCase;
import com.hexagonal.crudl.domain.port.out.UsuarioRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class CrearUsuarioService implements CrearUsuarioUseCase {

    private final UsuarioRepositoryPort repositoryPort;

    public CrearUsuarioService(UsuarioRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public Usuario ejecutar(CrearUsuarioCommand comando) {
        Cedula cedula = new Cedula(comando.cedula());

        if (repositoryPort.existePorCedula(cedula)) {
            throw new UsuarioDuplicadoException(comando.cedula());
        }

        Usuario usuario = new Usuario(
                cedula,
                comando.password(),
                comando.nombre(),
                new Email(comando.email())
        );

        return repositoryPort.guardar(usuario);
    }
}
