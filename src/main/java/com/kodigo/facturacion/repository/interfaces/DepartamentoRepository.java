package com.kodigo.facturacion.repository.interfaces;

import com.kodigo.facturacion.persistence.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
}
