package com.hexagonal.crudl.application.service;

import com.hexagonal.crudl.application.command.ActualizarBibliotecaCommand;
import com.hexagonal.crudl.domain.exception.BibliotecaNoEncontradaException;
import com.hexagonal.crudl.domain.model.Biblioteca;
import com.hexagonal.crudl.domain.model.BibliotecaId;
import com.hexagonal.crudl.domain.model.Direccion;
import com.hexagonal.crudl.domain.model.Email;
import com.hexagonal.crudl.domain.model.HorarioAtencion;
import com.hexagonal.crudl.domain.port.in.ActualizarBibliotecaUseCase;
import com.hexagonal.crudl.domain.port.out.BibliotecaRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class ActualizarBibliotecaService implements ActualizarBibliotecaUseCase {

    private final BibliotecaRepositoryPort repositoryPort;

    public ActualizarBibliotecaService(BibliotecaRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public Biblioteca ejecutar(ActualizarBibliotecaCommand comando) {
        BibliotecaId id = new BibliotecaId(comando.id());

        Biblioteca biblioteca = repositoryPort.buscarPorId(id)
                .orElseThrow(() -> new BibliotecaNoEncontradaException(comando.id()));

        biblioteca.actualizarDatos(
                comando.nombre(),
                new Direccion(comando.direccion(), comando.ciudad(), comando.pais()),
                comando.telefono(),
                new Email(comando.email()),
                new HorarioAtencion(comando.horarioApertura(), comando.horarioCierre()),
                comando.numLibros(),
                comando.numUsuarios(),
                comando.esPublica(),
                comando.web()
        );

        return repositoryPort.guardar(biblioteca);
    }
}
