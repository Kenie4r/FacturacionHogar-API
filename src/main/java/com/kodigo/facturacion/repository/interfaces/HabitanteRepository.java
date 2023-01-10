package com.kodigo.facturacion.repository.interfaces;

import com.kodigo.facturacion.persistence.Habitante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface HabitanteRepository extends JpaRepository<Habitante,Long> {
    @Transactional
    @Modifying
    @Query("delete from Habitante h where h.casa.codigoCasa = ?1")
    void eliminarHabitantesDeCasa(Long casaId);

}
