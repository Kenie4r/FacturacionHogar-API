package com.kodigo.facturacion.service.interfaces;

import com.kodigo.facturacion.persistence.Propietario;

public interface PropietarioService {
    Propietario guardarPropetario(Propietario propietario);
    Propietario conseguirPropetarioPorId(Long propietarioId);
    Propietario actualizarPropietario(Propietario propietario, Long propietarioId);
    void eliminarPropietario(Long propietarioId);
}
