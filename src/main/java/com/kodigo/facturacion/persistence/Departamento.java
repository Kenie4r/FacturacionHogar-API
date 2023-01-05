package com.kodigo.facturacion.persistence;

import jakarta.persistence.*;
import lombok.Data;

@Data@Entity@Table(name = "Departamento")
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoDepartamento;
    @Column(name = "NombreDepartamento", nullable = false)
    private String nombreDepartamento;
    @ManyToOne
    @JoinColumn(name = "País_CodigoPais")
    private Pais pais;
}
