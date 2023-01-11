package com.kodigo.facturacion.requestbody;

import lombok.Data;

@Data
public class CuerpoCargo {
    private String nombreCargo;
    private double monto;
    private Long facturaId;
}
