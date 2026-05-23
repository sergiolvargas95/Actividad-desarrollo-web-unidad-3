package com.hexagonal.crudl.application.service;

import com.hexagonal.crudl.application.command.CrearBibliotecaCommand;
import com.hexagonal.crudl.domain.model.Biblioteca;
import com.hexagonal.crudl.domain.model.BibliotecaId;
import com.hexagonal.crudl.domain.model.Direccion;
import com.hexagonal.crudl.domain.model.Email;
import com.hexagonal.crudl.domain.model.HorarioAtencion;
import com.hexagonal.crudl.domain.port.in.CrearBibliotecaUseCase;
import com.hexagonal.crudl.domain.port.out.BibliotecaRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class CrearBibliotecaService implements CrearBibliotecaUseCase {

    private final BibliotecaRepositoryPort repositoryPort;

    public CrearBibliotecaService(BibliotecaRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public Biblioteca ejecutar(CrearBibliotecaCommand comando) {
        Biblioteca biblioteca = new Biblioteca(
                new BibliotecaId(null),
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
