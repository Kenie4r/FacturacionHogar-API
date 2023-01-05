package com.kodigo.facturacion.persistence;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Casa")
public class Casa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoCasa;
    @Column(name = "NumeroCasa", nullable = false)
    private String numeroCasa;
    @Column(name = "CostoMantenimiento", nullable = false)
    private double costoMantenimiento;

    @ManyToOne
    @JoinColumn(name = "Propietario_CodigoPropietario", nullable = false)
    private  Propietario propietario;

    @ManyToOne
    @JoinColumn(name = "Departamento_CodigoDepartamento")
    private Departamento departamento;
    @ManyToOne
    @JoinColumn(name = "País_CodigoPais")
    private Pais pais;
    @ManyToOne
    @JoinColumn(name = "Municipio_CodigoMunicipio")
    private Municipio municipio;



}
