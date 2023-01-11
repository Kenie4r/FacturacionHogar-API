package com.kodigo.facturacion.persistence;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@Table(name = "país", schema = "fhopenet_app-kodigo")
@NoArgsConstructor @AllArgsConstructor
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    @Getter
    private Long codigoPais;

    @Column(name = "NombrePais")
    @Setter
    @Getter
    private String nombrePais;

}
