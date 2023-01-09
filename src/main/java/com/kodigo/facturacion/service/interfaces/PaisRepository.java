package com.kodigo.facturacion.service.interfaces;

import com.kodigo.facturacion.persistence.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
public interface PaisRepository extends JpaRepository<Pais, Long> {

}
