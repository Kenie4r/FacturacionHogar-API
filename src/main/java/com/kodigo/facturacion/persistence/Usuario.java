package com.kodigo.facturacion.persistence;

import jakarta.persistence.*;
import lombok.Data;

@Data @Entity @Table(name = "usuario", schema = "fhopenet_app-kodigo")
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    @Column(name = "Nombre",  nullable = false)
    private String nombre;
    @Column(name = "Password", nullable = false)
    private String password;
}
