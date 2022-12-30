package com.kodigo.facturacion.repository.interfaces;

import com.kodigo.facturacion.persistence.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
}
