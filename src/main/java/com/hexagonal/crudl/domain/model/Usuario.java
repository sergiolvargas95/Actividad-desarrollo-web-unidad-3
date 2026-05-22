package com.hexagonal.crudl.domain.model;

import com.hexagonal.crudl.domain.exception.UsuarioInvalidoException;

public class Usuario {

    private final Cedula cedula;
    private String password;
    private String nombre;
    private Email email;

    public Usuario(Cedula cedula, String password, String nombre, Email email) {
        if (password == null || password.isBlank()) {
            throw new UsuarioInvalidoException("El password no puede estar vacío");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new UsuarioInvalidoException("El nombre no puede estar vacío");
        }
        this.cedula = cedula;
        this.password = password;
        this.nombre = nombre;
        this.email = email;
    }

    public void actualizarDatos(String password, String nombre, Email email) {
        if (password != null && !password.isBlank()) {
            this.password = password;
        }
        if (nombre != null && !nombre.isBlank()) {
            this.nombre = nombre;
        }
        this.email = email;
    }

    public Cedula getCedula() {
        return cedula;
    }

    public String getPassword() {
        return password;
    }

    public String getNombre() {
        return nombre;
    }

    public Email getEmail() {
        return email;
    }
}
