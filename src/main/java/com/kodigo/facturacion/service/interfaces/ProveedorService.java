package com.kodigo.facturacion.service.interfaces;

import com.kodigo.facturacion.persistence.Proveedor;

import java.util.List;

public interface ProveedorService {

    List<Proveedor> obtenerProveedores();
    Proveedor obtenerProveedorPorID(Long id);
    String guardarProveedor(Proveedor proveedor);

    String eliminarProveedor(Long id);

    String actualizarProveedor(Proveedor proveedor);

    List<Proveedor> obtenerProveedorPorNombre(String nombre);
}
