package com.hexagonal.crudl.application.service;

import com.hexagonal.crudl.application.query.ObtenerBibliotecaPorIdQuery;
import com.hexagonal.crudl.domain.exception.BibliotecaNoEncontradaException;
import com.hexagonal.crudl.domain.model.Biblioteca;
import com.hexagonal.crudl.domain.model.BibliotecaId;
import com.hexagonal.crudl.domain.port.in.ObtenerBibliotecaPorIdUseCase;
import com.hexagonal.crudl.domain.port.out.BibliotecaRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class ObtenerBibliotecaPorIdService implements ObtenerBibliotecaPorIdUseCase {

    private final BibliotecaRepositoryPort repositoryPort;

    public ObtenerBibliotecaPorIdService(BibliotecaRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public Biblioteca ejecutar(ObtenerBibliotecaPorIdQuery query) {
        BibliotecaId id = new BibliotecaId(query.id());

        return repositoryPort.buscarPorId(id)
                .orElseThrow(() -> new BibliotecaNoEncontradaException(query.id()));
    }
}
