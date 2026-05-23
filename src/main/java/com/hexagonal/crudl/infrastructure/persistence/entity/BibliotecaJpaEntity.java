package com.hexagonal.crudl.infrastructure.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Entity
@Table(name = "bibliotecas")
@Data
@NoArgsConstructor
public class BibliotecaJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String nombre;

    @Column(length = 200, nullable = false)
    private String direccion;

    @Column(length = 100, nullable = false)
    private String ciudad;

    @Column(length = 100, nullable = false)
    private String pais;

    @Column(length = 20)
    private String telefono;

    @Column(length = 100)
    private String email;

    @Column(name = "horario_apertura")
    private LocalTime horarioApertura;

    @Column(name = "horario_cierre")
    private LocalTime horarioCierre;

    @Column(name = "num_libros")
    private Integer numLibros;

    @Column(name = "num_usuarios")
    private Integer numUsuarios;

    @Column(name = "es_publica", nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0")
    private boolean esPublica;

    @Column(length = 200)
    private String web;

    public BibliotecaJpaEntity(
            Long id,
            String nombre,
            String direccion,
            String ciudad,
            String pais,
            String telefono,
            String email,
            LocalTime horarioApertura,
            LocalTime horarioCierre,
            Integer numLibros,
            Integer numUsuarios,
            boolean esPublica,
            String web) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.pais = pais;
        this.telefono = telefono;
        this.email = email;
        this.horarioApertura = horarioApertura;
        this.horarioCierre = horarioCierre;
        this.numLibros = numLibros;
        this.numUsuarios = numUsuarios;
        this.esPublica = esPublica;
        this.web = web;
    }
}
