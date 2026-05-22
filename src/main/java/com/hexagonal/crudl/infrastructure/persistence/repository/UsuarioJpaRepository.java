package com.hexagonal.crudl.infrastructure.persistence.repository;

import com.hexagonal.crudl.infrastructure.persistence.entity.UsuarioJpaEntity;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioJpaRepository extends CrudRepository<UsuarioJpaEntity, String> {}
