package com.hexagonal.crudl.infrastructure.web.mapper;

import com.hexagonal.crudl.domain.model.Biblioteca;
import com.hexagonal.crudl.infrastructure.web.dto.BibliotecaResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BibliotecaWebMapper {

    public BibliotecaResponse aResponse(Biblioteca biblioteca) {
        return new BibliotecaResponse(
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

    public List<BibliotecaResponse> aListaResponse(List<Biblioteca> bibliotecas) {
        return bibliotecas.stream()
                .map(this::aResponse)
                .toList();
    }
}
