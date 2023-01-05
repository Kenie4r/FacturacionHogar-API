package com.kodigo.facturacion.persistence;


import jakarta.persistence.*;
import lombok.Data;

@Data @Entity @Table(name = "Cargo")
public class Cargo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdCargo;
    @Column(name = "NombreCargo", nullable = false)
    private String nombreCargo;
    @Column(name = "Monto", nullable = false)
    private double monto;
    @ManyToOne
    @JoinColumn(name = "Factura_idFactura")
    private Factura factura;
}
