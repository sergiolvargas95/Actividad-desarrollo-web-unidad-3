package com.hexagonal.crudl.infrastructure.persistence.adapter;

import com.hexagonal.crudl.domain.model.Biblioteca;
import com.hexagonal.crudl.domain.model.BibliotecaId;
import com.hexagonal.crudl.domain.port.out.BibliotecaRepositoryPort;
import com.hexagonal.crudl.infrastructure.persistence.mapper.BibliotecaPersistenceMapper;
import com.hexagonal.crudl.infrastructure.persistence.repository.BibliotecaJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Component
public class BibliotecaRepositoryAdapter implements BibliotecaRepositoryPort {

    private final BibliotecaJpaRepository jpaRepository;
    private final BibliotecaPersistenceMapper mapper;

    public BibliotecaRepositoryAdapter(BibliotecaJpaRepository jpaRepository, BibliotecaPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Biblioteca guardar(Biblioteca biblioteca) {
        return mapper.toDomain(jpaRepository.save(mapper.toEntity(biblioteca)));
    }

    @Override
    public Optional<Biblioteca> buscarPorId(BibliotecaId id) {
        return jpaRepository.findById(id.getValor())
                .map(mapper::toDomain);
    }

    @Override
    public List<Biblioteca> buscarTodas() {
        return StreamSupport.stream(jpaRepository.findAll().spliterator(), false)
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void eliminar(BibliotecaId id) {
        jpaRepository.deleteById(id.getValor());
    }

    @Override
    public boolean existePorId(BibliotecaId id) {
        return jpaRepository.existsById(id.getValor());
    }
}
