package com.kodigo.facturacion.repository.interfaces;

import com.kodigo.facturacion.persistence.Habitante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitanteRepository extends JpaRepository<Habitante,Long> {
}
