package com.kodigo.facturacion.persistence;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "País")
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoPais;

    @Column(name = "NombrePais")
    private String nombrePais;

}
