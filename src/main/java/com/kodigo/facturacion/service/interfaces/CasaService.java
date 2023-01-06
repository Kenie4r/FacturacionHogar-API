package com.kodigo.facturacion.service.interfaces;

import com.kodigo.facturacion.persistence.Casa;

public interface CasaService {
    Casa guardarCasa(Casa casa);
    Casa guardarCasa(String numeroCasa,Double costoMantenimiento, Long codigoPropietario,
                     Long codigoDepartamento, Long codigoPais, Long codigoMunicipio);
}
