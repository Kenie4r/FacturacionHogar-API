package com.kodigo.facturacion.persistence;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "municipio", schema = "fhopenet_app-kodigo")
public class Municipio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoMunicipio;

    @Column(name = "Nombre", nullable = false)
    private String nombreMunicipio;

    @ManyToOne
    @JoinColumn(name = "Departamento_CodigoDepartamento", nullable = false)
    private Departamento departamento;

}
