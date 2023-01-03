package com.kodigo.facturacion.persistence;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;


@Data
@Entity
public class Servicio {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long codigoServicio;

    @Column(name = "NombreServicio", nullable = false)
    private String nombreServicio;
    @Column(name = "Tarifa", nullable = false)
    private double tarifa;
    @Column(name = "FechaSuspencion", nullable = false)
    private Date fechaSuspencion;
    @ManyToOne
    @JoinColumn(name = "Proveedor_CodigoProveedor")
    private Proveedor proveedor;
    @ManyToOne
    @JoinColumn(name = "Casa_CodigoCasa")
    private Casa casa;

}
