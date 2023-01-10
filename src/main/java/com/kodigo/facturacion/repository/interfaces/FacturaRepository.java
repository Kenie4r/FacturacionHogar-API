package com.kodigo.facturacion.repository.interfaces;

import com.kodigo.facturacion.persistence.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FacturaRepository extends JpaRepository<Factura, Long> {
    @Query("SELECT f FROM Factura  f WHERE f.servicio.codigoServicio = ?1")
    public List<Factura> getFacturaByServicioOrTotal(Long id);
}
