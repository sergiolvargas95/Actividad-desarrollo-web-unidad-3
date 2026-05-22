package com.hexagonal.crudl.application.service;

import com.hexagonal.crudl.application.command.ActualizarUsuarioCommand;
import com.hexagonal.crudl.domain.exception.UsuarioNoEncontradoException;
import com.hexagonal.crudl.domain.model.Cedula;
import com.hexagonal.crudl.domain.model.Email;
import com.hexagonal.crudl.domain.model.Usuario;
import com.hexagonal.crudl.domain.port.in.ActualizarUsuarioUseCase;
import com.hexagonal.crudl.domain.port.out.UsuarioRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class ActualizarUsuarioService implements ActualizarUsuarioUseCase {

    private final UsuarioRepositoryPort repositoryPort;

    public ActualizarUsuarioService(UsuarioRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public Usuario ejecutar(ActualizarUsuarioCommand comando) {
        Cedula cedula = new Cedula(comando.cedula());

        Usuario usuario = repositoryPort.buscarPorCedula(cedula)
                .orElseThrow(() -> new UsuarioNoEncontradoException(comando.cedula()));

        usuario.actualizarDatos(
                comando.password(),
                comando.nombre(),
                new Email(comando.email())
        );

        return repositoryPort.guardar(usuario);
    }
}
