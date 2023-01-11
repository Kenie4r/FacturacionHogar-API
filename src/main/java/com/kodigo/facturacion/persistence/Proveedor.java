package com.kodigo.facturacion.persistence;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "proveedor")
@NoArgsConstructor @AllArgsConstructor
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    @Getter
    private long codigoProveedor;
    @Column(name = "NombreProveedor", nullable = false )
    @Setter
    @Getter
    private String nombreProveedor;


}
