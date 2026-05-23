package com.hexagonal.crudl.infrastructure.persistence.repository;

import com.hexagonal.crudl.infrastructure.persistence.entity.BibliotecaJpaEntity;
import org.springframework.data.repository.CrudRepository;

public interface BibliotecaJpaRepository extends CrudRepository<BibliotecaJpaEntity, Long> {}
