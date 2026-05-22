package com.hexagonal.crudl.infrastructure.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
public class UsuarioJpaEntity {

    @Id
    @Column(length = 15, nullable = false)
    private String cedula;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nombre;

    @Column(length = 100)
    private String email;

    public UsuarioJpaEntity(String cedula, String password, String nombre, String email) {
        this.cedula = cedula;
        this.password = password;
        this.nombre = nombre;
        this.email = email;
    }
}
