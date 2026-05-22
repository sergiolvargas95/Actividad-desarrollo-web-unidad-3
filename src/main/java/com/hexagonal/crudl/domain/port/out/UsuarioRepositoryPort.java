package com.hexagonal.crudl.domain.port.out;

import com.hexagonal.crudl.domain.model.Cedula;
import com.hexagonal.crudl.domain.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepositoryPort {
    Usuario guardar(Usuario usuario);
    Optional<Usuario> buscarPorCedula(Cedula cedula);
    List<Usuario> buscarTodos();
    void eliminar(Cedula cedula);
    boolean existePorCedula(Cedula cedula);
}
