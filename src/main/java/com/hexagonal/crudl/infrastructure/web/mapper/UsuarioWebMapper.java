package com.hexagonal.crudl.infrastructure.web.mapper;

import com.hexagonal.crudl.domain.model.Usuario;
import com.hexagonal.crudl.infrastructure.web.dto.UsuarioResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioWebMapper {

    public UsuarioResponse aResponse(Usuario usuario) {
        return new UsuarioResponse(
                usuario.getCedula().getValor(),
                usuario.getNombre(),
                usuario.getEmail() != null && usuario.getEmail().estaPresente()
                        ? usuario.getEmail().getValor()
                        : null
        );
    }

    public List<UsuarioResponse> aListaResponse(List<Usuario> usuarios) {
        return usuarios.stream()
                .map(this::aResponse)
                .toList();
    }
}
