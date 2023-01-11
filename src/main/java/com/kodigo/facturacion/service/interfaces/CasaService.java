package com.kodigo.facturacion.service.interfaces;

import com.kodigo.facturacion.persistence.Casa;
import com.kodigo.facturacion.persistence.Habitante;
import com.kodigo.facturacion.requestbody.CuerpoCasa;

import java.util.List;

public interface CasaService {
    Casa guardarCasa(Casa casa);
    Casa guardarCasa(CuerpoCasa cuerpoCasa);
    Casa cargarCasaPorId(Long id);
    Habitante guardarHabitante(Long casaId,Habitante habitante);
    void eliminarCasa(long id);
    Casa actualizarCasa(CuerpoCasa cuerpoCasa,long id);

    List<Casa> listadoCasa();
}
