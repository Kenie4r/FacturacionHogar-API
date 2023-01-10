package com.kodigo.facturacion.service.interfaces;

import com.kodigo.facturacion.persistence.Casa;
import com.kodigo.facturacion.requestbody.AnadirCasa;

public interface CasaService {
    Casa guardarCasa(Casa casa);
    Casa guardarCasa(AnadirCasa anadirCasa);
    Casa cargarCasaPorId(Long id);
}
