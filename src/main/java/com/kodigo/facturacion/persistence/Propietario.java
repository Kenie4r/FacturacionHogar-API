package com.kodigo.facturacion.persistence;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "propietario", schema = "fhopenet_app-kodigo")
public class Propietario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoPropietario;

    @Column(name = "NombrePersona", nullable = false )
    private String nombrePersona;

    @Column(name = "Correo", nullable = false)
    private String correo;

}
