package com.kodigo.facturacion.persistence;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Proveedor", schema = "app-kodigo")
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
