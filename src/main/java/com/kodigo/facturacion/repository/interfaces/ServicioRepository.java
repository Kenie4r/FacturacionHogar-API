package com.kodigo.facturacion.repository.interfaces;

import com.kodigo.facturacion.persistence.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServicioRepository extends JpaRepository<Servicio,Long> {
    @Query("select s from Servicio  s WHERE s.casa.codigoCasa = ?1")
    public List<Servicio> getServiciosByCasa(Long idCasa);
}
