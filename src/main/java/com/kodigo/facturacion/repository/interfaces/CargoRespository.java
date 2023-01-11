package com.kodigo.facturacion.repository.interfaces;

import com.kodigo.facturacion.persistence.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CargoRespository extends JpaRepository<Cargo,Long> {
    List<Cargo> findByFactura_IdFactura(long idFactura);

}
