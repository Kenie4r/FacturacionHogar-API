package com.kodigo.facturacion.persistence;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "departamento", schema = "app-kodigo")
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoDepartamento;

    @Column(name = "NombreDepartamento",nullable = false)
    @Setter
    @Getter
    private String nombreDepartamento;

    @ManyToOne
    @JoinColumn(name = "País_CodigoPais")
    private Pais pais;
}
