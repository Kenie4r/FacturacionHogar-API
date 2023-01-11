package com.kodigo.facturacion.service.interfaces;

import com.kodigo.facturacion.persistence.Cargo;
import com.kodigo.facturacion.requestbody.CuerpoCargo;

import java.util.List;

public interface CargoService {
     Cargo guardarCargo(Cargo cargo);
     Cargo guardarCargo(CuerpoCargo cuerpoCargo);
     List<Cargo> cargarCargoPorFactura(long idFactura);
     void eliminarCargo(long cargoId);
     Cargo actualizarCargo(long cargoId,CuerpoCargo cuerpoCargo);
}
