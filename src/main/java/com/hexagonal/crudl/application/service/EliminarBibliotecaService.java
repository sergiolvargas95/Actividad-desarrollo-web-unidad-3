package com.hexagonal.crudl.application.service;

import com.hexagonal.crudl.application.command.EliminarBibliotecaCommand;
import com.hexagonal.crudl.domain.exception.BibliotecaNoEncontradaException;
import com.hexagonal.crudl.domain.model.BibliotecaId;
import com.hexagonal.crudl.domain.port.in.EliminarBibliotecaUseCase;
import com.hexagonal.crudl.domain.port.out.BibliotecaRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class EliminarBibliotecaService implements EliminarBibliotecaUseCase {

    private final BibliotecaRepositoryPort repositoryPort;

    public EliminarBibliotecaService(BibliotecaRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public void ejecutar(EliminarBibliotecaCommand comando) {
        BibliotecaId id = new BibliotecaId(comando.id());

        if (!repositoryPort.existePorId(id)) {
            throw new BibliotecaNoEncontradaException(comando.id());
        }

        repositoryPort.eliminar(id);
    }
}
