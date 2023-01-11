package com.kodigo.facturacion.repository.interfaces;

import com.kodigo.facturacion.persistence.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
//DATA JPA
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
    @Query("SELECT p FROM Proveedor p WHERE p.nombreProveedor LIKE ?1")
    public List<Proveedor> getProveedorByNombreProveedorContaining(String str);

}
