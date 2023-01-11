package com.kodigo.facturacion.persistence;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="habitante", schema = "fhopenet_app-kodigo")
public class Habitante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigoHabitante;
    @Column(name = "NombreHabitante", nullable = false)
    private String nombreHabitante;
    @Column(name = "Correo", nullable = false)
    private String correo;
    @ManyToOne
    @JoinColumn(name = "Casa_CodigoCasa")
    private Casa casa;
}
