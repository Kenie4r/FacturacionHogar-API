package com.kodigo.facturacion.persistence;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Data @Entity @Table(name = "cargo")
public class Cargo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdCargo;
    @Column(name = "NombreCargo", nullable = false)
    private String nombreCargo;
    @Column(name = "Monto", nullable = false)
    private double monto;
    @ManyToOne
    @JoinColumn(name = "Factura_idFactura")
    @JsonBackReference
    private Factura factura;
}
