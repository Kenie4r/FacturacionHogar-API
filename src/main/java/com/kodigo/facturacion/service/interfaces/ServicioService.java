package com.kodigo.facturacion.service.interfaces;

import com.kodigo.facturacion.persistence.Servicio;
import com.kodigo.facturacion.requestbody.CuerpoServicio;

import java.util.List;

public interface ServicioService {
    Servicio guardarServicio(Servicio servicio);
    Servicio guardarServicio(CuerpoServicio cuerpoServicio);
    Servicio cargarServicioPorId(Long servicioId);
    void eliminarServicio(Long servicioId);
    Servicio actualizarServicio(Long servicioId, CuerpoServicio cuerpoServicio);

    List<Servicio> obtenerServiciosPorCasa(Long id);
}
