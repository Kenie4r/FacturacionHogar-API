package com.kodigo.facturacion.service.interfaces;

import com.kodigo.facturacion.persistence.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaisRepository extends JpaRepository<Pais, Long> {

}
