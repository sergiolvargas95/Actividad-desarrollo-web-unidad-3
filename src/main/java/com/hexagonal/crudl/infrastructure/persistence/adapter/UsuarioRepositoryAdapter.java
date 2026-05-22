package com.hexagonal.crudl.infrastructure.persistence.adapter;

import com.hexagonal.crudl.domain.model.Cedula;
import com.hexagonal.crudl.domain.model.Usuario;
import com.hexagonal.crudl.domain.port.out.UsuarioRepositoryPort;
import com.hexagonal.crudl.infrastructure.persistence.mapper.UsuarioPersistenceMapper;
import com.hexagonal.crudl.infrastructure.persistence.repository.UsuarioJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Component
public class UsuarioRepositoryAdapter implements UsuarioRepositoryPort {

    private final UsuarioJpaRepository jpaRepository;
    private final UsuarioPersistenceMapper mapper;

    public UsuarioRepositoryAdapter(UsuarioJpaRepository jpaRepository, UsuarioPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        UsuarioJpaEntity entidad = mapper.toEntity(usuario);
        UsuarioJpaEntity guardada = jpaRepository.save(entidad);
        return mapper.toDomain(guardada);
    }

    @Override
    public Optional<Usuario> buscarPorCedula(Cedula cedula) {
        return jpaRepository.findById(cedula.getValor())
                .map(mapper::toDomain);
    }

    @Override
    public List<Usuario> buscarTodos() {
        return StreamSupport.stream(jpaRepository.findAll().spliterator(), false)
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void eliminar(Cedula cedula) {
        jpaRepository.deleteById(cedula.getValor());
    }

    @Override
    public boolean existePorCedula(Cedula cedula) {
        return jpaRepository.existsById(cedula.getValor());
    }
}
