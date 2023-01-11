package com.kodigo.facturacion.requestbody;

import lombok.Data;

import java.sql.Date;

@Data
public class CuerpoServicio {
    private long codigoServicio;
    private String nombreServicio;
    private Double tarifa;
    private Date fechaSuspencion;
    private long codigoCasa;
    private long codigoProveedor;
}
