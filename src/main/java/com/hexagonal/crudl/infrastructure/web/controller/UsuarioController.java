package com.hexagonal.crudl.infrastructure.web.controller;

import com.hexagonal.crudl.application.command.ActualizarUsuarioCommand;
import com.hexagonal.crudl.application.command.CrearUsuarioCommand;
import com.hexagonal.crudl.application.command.EliminarUsuarioCommand;
import com.hexagonal.crudl.application.query.ObtenerTodosUsuariosQuery;
import com.hexagonal.crudl.application.query.ObtenerUsuarioPorCedulaQuery;
import com.hexagonal.crudl.domain.model.Usuario;
import com.hexagonal.crudl.domain.port.in.ActualizarUsuarioUseCase;
import com.hexagonal.crudl.domain.port.in.CrearUsuarioUseCase;
import com.hexagonal.crudl.domain.port.in.EliminarUsuarioUseCase;
import com.hexagonal.crudl.domain.port.in.ObtenerTodosUsuariosUseCase;
import com.hexagonal.crudl.domain.port.in.ObtenerUsuarioPorCedulaUseCase;
import com.hexagonal.crudl.infrastructure.web.dto.ActualizarUsuarioRequest;
import com.hexagonal.crudl.infrastructure.web.dto.CrearUsuarioRequest;
import com.hexagonal.crudl.infrastructure.web.dto.UsuarioResponse;
import com.hexagonal.crudl.infrastructure.web.mapper.UsuarioWebMapper;
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
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final CrearUsuarioUseCase crearUsuario;
    private final ActualizarUsuarioUseCase actualizarUsuario;
    private final EliminarUsuarioUseCase eliminarUsuario;
    private final ObtenerTodosUsuariosUseCase obtenerTodos;
    private final ObtenerUsuarioPorCedulaUseCase obtenerPorCedula;
    private final UsuarioWebMapper mapper;

    public UsuarioController(
            CrearUsuarioUseCase crearUsuario,
            ActualizarUsuarioUseCase actualizarUsuario,
            EliminarUsuarioUseCase eliminarUsuario,
            ObtenerTodosUsuariosUseCase obtenerTodos,
            ObtenerUsuarioPorCedulaUseCase obtenerPorCedula,
            UsuarioWebMapper mapper) {
        this.crearUsuario = crearUsuario;
        this.actualizarUsuario = actualizarUsuario;
        this.eliminarUsuario = eliminarUsuario;
        this.obtenerTodos = obtenerTodos;
        this.obtenerPorCedula = obtenerPorCedula;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> listar() {
        List<Usuario> usuarios = obtenerTodos.ejecutar(new ObtenerTodosUsuariosQuery());
        return ResponseEntity.ok(mapper.aListaResponse(usuarios));
    }

    @GetMapping("/{cedula}")
    public ResponseEntity<UsuarioResponse> obtenerPorCedula(@PathVariable String cedula) {
        Usuario usuario = obtenerPorCedula.ejecutar(new ObtenerUsuarioPorCedulaQuery(cedula));
        return ResponseEntity.ok(mapper.aResponse(usuario));
    }

    @PostMapping
    public ResponseEntity<UsuarioResponse> crear(@Valid @RequestBody CrearUsuarioRequest request) {
        Usuario usuario = crearUsuario.ejecutar(new CrearUsuarioCommand(
                request.cedula(),
                request.password(),
                request.nombre(),
                request.email()
        ));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.aResponse(usuario));
    }

    @PutMapping("/{cedula}")
    public ResponseEntity<UsuarioResponse> actualizar(
            @PathVariable String cedula,
            @Valid @RequestBody ActualizarUsuarioRequest request) {
        Usuario usuario = actualizarUsuario.ejecutar(new ActualizarUsuarioCommand(
                cedula,
                request.password(),
                request.nombre(),
                request.email()
        ));
        return ResponseEntity.ok(mapper.aResponse(usuario));
    }

    @DeleteMapping("/{cedula}")
    public ResponseEntity<Void> eliminar(@PathVariable String cedula) {
        eliminarUsuario.ejecutar(new EliminarUsuarioCommand(cedula));
        return ResponseEntity.noContent().build();
    }
}
