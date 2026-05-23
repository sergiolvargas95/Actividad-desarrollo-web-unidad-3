package com.hexagonal.crudl.application.service;

import com.hexagonal.crudl.application.query.ObtenerTodasBibliotecasQuery;
import com.hexagonal.crudl.domain.model.Biblioteca;
import com.hexagonal.crudl.domain.port.in.ObtenerTodasBibliotecasUseCase;
import com.hexagonal.crudl.domain.port.out.BibliotecaRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObtenerTodasBibliotecasService implements ObtenerTodasBibliotecasUseCase {

    private final BibliotecaRepositoryPort repositoryPort;

    public ObtenerTodasBibliotecasService(BibliotecaRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public List<Biblioteca> ejecutar(ObtenerTodasBibliotecasQuery query) {
        return repositoryPort.buscarTodas();
    }
}
