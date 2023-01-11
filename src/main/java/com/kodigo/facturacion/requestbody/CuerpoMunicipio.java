package com.kodigo.facturacion.requestbody;

import com.kodigo.facturacion.persistence.Departamento;
import lombok.Data;

@Data
public class CuerpoMunicipio {
    private String nombreMunicipio;
    private Long codigoDepartamento;
}
