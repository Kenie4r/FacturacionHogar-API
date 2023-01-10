package com.kodigo.facturacion.persistence;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
@Entity
@Table(name = "factura")
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
    @OneToMany(mappedBy = "factura")
    @JsonManagedReference
    private List<Cargo> cargos;
}
