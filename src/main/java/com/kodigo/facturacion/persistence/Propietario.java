package com.kodigo.facturacion.persistence;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "propietario")
public class Propietario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoPropietario;

    @Column(name = "NombrePresona", nullable = false )
    private String nombrePersona;

    @Column(name = "Correo", nullable = false)
    private String correo;

}
