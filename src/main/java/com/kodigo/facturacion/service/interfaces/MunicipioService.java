package com.kodigo.facturacion.service.interfaces;

import com.kodigo.facturacion.persistence.Habitante;
import com.kodigo.facturacion.persistence.Municipio;
import com.kodigo.facturacion.requestbody.CuerpoMunicipio;

public interface MunicipioService {

    Municipio anadirMunicipio(Municipio municipio);
    Municipio anadirMunicipio(CuerpoMunicipio cuerpoMunicipio);
    Municipio cargarMunicipioPorId(Long municipioId);
    void eliminarMunicipioPorId(Long municipioId);
    Municipio actualizarMunicipio(Long municipioId, CuerpoMunicipio cuerpoMunicipio);

}
