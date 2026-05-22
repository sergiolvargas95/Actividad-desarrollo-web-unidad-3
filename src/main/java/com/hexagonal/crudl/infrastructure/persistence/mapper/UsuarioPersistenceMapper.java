package com.hexagonal.crudl.infrastructure.persistence.mapper;

import com.hexagonal.crudl.domain.model.Cedula;
import com.hexagonal.crudl.domain.model.Email;
import com.hexagonal.crudl.domain.model.Usuario;
import com.hexagonal.crudl.infrastructure.persistence.entity.UsuarioJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class UsuarioPersistenceMapper {

    public Usuario toDomain(UsuarioJpaEntity entity) {
        return new Usuario(
                new Cedula(entity.getCedula()),
                entity.getPassword(),
                entity.getNombre(),
                new Email(entity.getEmail())
        );
    }

    public UsuarioJpaEntity toEntity(Usuario usuario) {
        return new UsuarioJpaEntity(
                usuario.getCedula().getValor(),
                usuario.getPassword(),
                usuario.getNombre(),
                usuario.getEmail() != null ? usuario.getEmail().getValor() : null
        );
    }
}
