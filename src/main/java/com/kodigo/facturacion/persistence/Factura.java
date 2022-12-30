package com.kodigo.facturacion.persistence;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity(name =  "Factura")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFactura;
    @Column(name = "FechaExpidacion", nullable = false)
    private Date fechaExpidacion;
    @Column(name = "Total", nullable = false)
    private double total;
    @ManyToOne
    @JoinColumn(name = "Servicio_CodigoServicio")
    private Servicio servicio;
}
