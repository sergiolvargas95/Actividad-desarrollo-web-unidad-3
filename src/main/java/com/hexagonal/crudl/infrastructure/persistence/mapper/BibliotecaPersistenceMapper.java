package com.hexagonal.crudl.infrastructure.persistence.mapper;

import com.hexagonal.crudl.domain.model.Biblioteca;
import com.hexagonal.crudl.domain.model.BibliotecaId;
import com.hexagonal.crudl.domain.model.Direccion;
import com.hexagonal.crudl.domain.model.Email;
import com.hexagonal.crudl.domain.model.HorarioAtencion;
import com.hexagonal.crudl.infrastructure.persistence.entity.BibliotecaJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class BibliotecaPersistenceMapper {

    public Biblioteca toDomain(BibliotecaJpaEntity entity) {
        return new Biblioteca(
                new BibliotecaId(entity.getId()),
                entity.getNombre(),
                new Direccion(entity.getDireccion(), entity.getCiudad(), entity.getPais()),
                entity.getTelefono(),
                new Email(entity.getEmail()),
                new HorarioAtencion(entity.getHorarioApertura(), entity.getHorarioCierre()),
                entity.getNumLibros(),
                entity.getNumUsuarios(),
                entity.isEsPublica(),
                entity.getWeb()
        );
    }

    public BibliotecaJpaEntity toEntity(Biblioteca biblioteca) {
        return new BibliotecaJpaEntity(
                biblioteca.getId().getValor(),
                biblioteca.getNombre(),
                biblioteca.getDireccion().getDireccion(),
                biblioteca.getDireccion().getCiudad(),
                biblioteca.getDireccion().getPais(),
                biblioteca.getTelefono(),
                biblioteca.getEmail() != null && biblioteca.getEmail().estaPresente()
                        ? biblioteca.getEmail().getValor()
                        : null,
                biblioteca.getHorario() != null ? biblioteca.getHorario().getApertura() : null,
                biblioteca.getHorario() != null ? biblioteca.getHorario().getCierre() : null,
                biblioteca.getNumLibros(),
                biblioteca.getNumUsuarios(),
                biblioteca.isEsPublica(),
                biblioteca.getWeb()
        );
    }
}
