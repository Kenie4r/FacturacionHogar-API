package com.kodigo.facturacion.requestbody;

import lombok.Data;

@Data
public class CuerpoCasa {
    public String numeroCasa;
    public Double costoMantenimiento;
    public Long codigoPropietario;
    public Long codigoDepartamento;
    public Long codigoPais;
    public Long codigoMunicipio;
}
