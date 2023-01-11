package com.kodigo.facturacion.service.interfaces;

import com.kodigo.facturacion.persistence.Factura;

import java.util.List;

public interface FacturaService {
    String guardarFactura(Factura factura);
    String eliminarFactura(Long id);
    String actualizarFactura(Factura baseFactura, Long id);
    Factura obtenerFacturaPorCodigo(Long id);
    List<Factura> listadoDeFacturas();
   List<Factura> listadoDeFacturasSerivicio(Long id);
}
