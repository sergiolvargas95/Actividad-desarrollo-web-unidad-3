package com.hexagonal.crudl.domain.model;

import com.hexagonal.crudl.domain.exception.BibliotecaInvalidaException;

public class Biblioteca {

    private final BibliotecaId id;
    private String nombre;
    private Direccion direccion;
    private String telefono;
    private Email email;
    private HorarioAtencion horario;
    private Integer numLibros;
    private Integer numUsuarios;
    private boolean esPublica;
    private String web;

    public Biblioteca(
            BibliotecaId id,
            String nombre,
            Direccion direccion,
            String telefono,
            Email email,
            HorarioAtencion horario,
            Integer numLibros,
            Integer numUsuarios,
            boolean esPublica,
            String web) {
        if (nombre == null || nombre.isBlank()) {
            throw new BibliotecaInvalidaException("El nombre de la biblioteca no puede estar vacío");
        }
        if (numLibros != null && numLibros < 0) {
            throw new BibliotecaInvalidaException("El número de libros no puede ser negativo");
        }
        if (numUsuarios != null && numUsuarios < 0) {
            throw new BibliotecaInvalidaException("El número de usuarios no puede ser negativo");
        }
        this.id = id;
        this.nombre = nombre.trim();
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.horario = horario;
        this.numLibros = numLibros;
        this.numUsuarios = numUsuarios;
        this.esPublica = esPublica;
        this.web = web;
    }

    public void actualizarDatos(
            String nombre,
            Direccion direccion,
            String telefono,
            Email email,
            HorarioAtencion horario,
            Integer numLibros,
            Integer numUsuarios,
            boolean esPublica,
            String web) {
        if (nombre == null || nombre.isBlank()) {
            throw new BibliotecaInvalidaException("El nombre de la biblioteca no puede estar vacío");
        }
        if (numLibros != null && numLibros < 0) {
            throw new BibliotecaInvalidaException("El número de libros no puede ser negativo");
        }
        if (numUsuarios != null && numUsuarios < 0) {
            throw new BibliotecaInvalidaException("El número de usuarios no puede ser negativo");
        }
        this.nombre = nombre.trim();
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.horario = horario;
        this.numLibros = numLibros;
        this.numUsuarios = numUsuarios;
        this.esPublica = esPublica;
        this.web = web;
    }

    public BibliotecaId getId() { return id; }
    public String getNombre() { return nombre; }
    public Direccion getDireccion() { return direccion; }
    public String getTelefono() { return telefono; }
    public Email getEmail() { return email; }
    public HorarioAtencion getHorario() { return horario; }
    public Integer getNumLibros() { return numLibros; }
    public Integer getNumUsuarios() { return numUsuarios; }
    public boolean isEsPublica() { return esPublica; }
    public String getWeb() { return web; }
}
