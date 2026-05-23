package com.hexagonal.crudl.infrastructure.web.controller;

import com.hexagonal.crudl.application.command.ActualizarBibliotecaCommand;
import com.hexagonal.crudl.application.command.CrearBibliotecaCommand;
import com.hexagonal.crudl.application.command.EliminarBibliotecaCommand;
import com.hexagonal.crudl.application.query.ObtenerBibliotecaPorIdQuery;
import com.hexagonal.crudl.application.query.ObtenerTodasBibliotecasQuery;
import com.hexagonal.crudl.domain.model.Biblioteca;
import com.hexagonal.crudl.domain.port.in.ActualizarBibliotecaUseCase;
import com.hexagonal.crudl.domain.port.in.CrearBibliotecaUseCase;
import com.hexagonal.crudl.domain.port.in.EliminarBibliotecaUseCase;
import com.hexagonal.crudl.domain.port.in.ObtenerBibliotecaPorIdUseCase;
import com.hexagonal.crudl.domain.port.in.ObtenerTodasBibliotecasUseCase;
import com.hexagonal.crudl.infrastructure.web.dto.ActualizarBibliotecaRequest;
import com.hexagonal.crudl.infrastructure.web.dto.BibliotecaResponse;
import com.hexagonal.crudl.infrastructure.web.dto.CrearBibliotecaRequest;
import com.hexagonal.crudl.infrastructure.web.mapper.BibliotecaWebMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bibliotecas")
public class BibliotecaController {

    private final CrearBibliotecaUseCase crearBiblioteca;
    private final ActualizarBibliotecaUseCase actualizarBiblioteca;
    private final EliminarBibliotecaUseCase eliminarBiblioteca;
    private final ObtenerTodasBibliotecasUseCase obtenerTodas;
    private final ObtenerBibliotecaPorIdUseCase obtenerPorId;
    private final BibliotecaWebMapper mapper;

    public BibliotecaController(
            CrearBibliotecaUseCase crearBiblioteca,
            ActualizarBibliotecaUseCase actualizarBiblioteca,
            EliminarBibliotecaUseCase eliminarBiblioteca,
            ObtenerTodasBibliotecasUseCase obtenerTodas,
            ObtenerBibliotecaPorIdUseCase obtenerPorId,
            BibliotecaWebMapper mapper) {
        this.crearBiblioteca = crearBiblioteca;
        this.actualizarBiblioteca = actualizarBiblioteca;
        this.eliminarBiblioteca = eliminarBiblioteca;
        this.obtenerTodas = obtenerTodas;
        this.obtenerPorId = obtenerPorId;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<BibliotecaResponse>> listar() {
        List<Biblioteca> bibliotecas = obtenerTodas.ejecutar(new ObtenerTodasBibliotecasQuery());
        return ResponseEntity.ok(mapper.aListaResponse(bibliotecas));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BibliotecaResponse> obtenerPorId(@PathVariable Long id) {
        Biblioteca biblioteca = obtenerPorId.ejecutar(new ObtenerBibliotecaPorIdQuery(id));
        return ResponseEntity.ok(mapper.aResponse(biblioteca));
    }

    @PostMapping
    public ResponseEntity<BibliotecaResponse> crear(@Valid @RequestBody CrearBibliotecaRequest request) {
        Biblioteca biblioteca = crearBiblioteca.ejecutar(new CrearBibliotecaCommand(
                request.nombre(),
                request.direccion(),
                request.ciudad(),
                request.pais(),
                request.telefono(),
                request.email(),
                request.horarioApertura(),
                request.horarioCierre(),
                request.numLibros(),
                request.numUsuarios(),
                request.esPublica(),
                request.web()
        ));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.aResponse(biblioteca));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BibliotecaResponse> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody ActualizarBibliotecaRequest request) {
        Biblioteca biblioteca = actualizarBiblioteca.ejecutar(new ActualizarBibliotecaCommand(
                id,
                request.nombre(),
                request.direccion(),
                request.ciudad(),
                request.pais(),
                request.telefono(),
                request.email(),
                request.horarioApertura(),
                request.horarioCierre(),
                request.numLibros(),
                request.numUsuarios(),
                request.esPublica(),
                request.web()
        ));
        return ResponseEntity.ok(mapper.aResponse(biblioteca));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        eliminarBiblioteca.ejecutar(new EliminarBibliotecaCommand(id));
        return ResponseEntity.noContent().build();
    }
}
