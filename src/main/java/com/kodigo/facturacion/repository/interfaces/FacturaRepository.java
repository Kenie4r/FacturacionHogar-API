package com.kodigo.facturacion.repository.interfaces;

import com.kodigo.facturacion.persistence.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, Long> {
}
