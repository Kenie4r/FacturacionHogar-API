package com.kodigo.facturacion.service.interfaces;

import com.kodigo.facturacion.persistence.Habitante;
import com.kodigo.facturacion.requestbody.CuerpoHabitante;

public interface HabitanteService {
    Habitante anadirHabitante(Habitante habitante);
    Habitante anadirHabitante(CuerpoHabitante cuerpoHabitante);
    Habitante cargarHabitantePorId(Long habitanteId);
    void eliminarHabitantePorId(Long habitanteId);
    Habitante actualizarHabitante(Long habitanteId, CuerpoHabitante cuerpoHabitante);
}
