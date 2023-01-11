package com.kodigo.facturacion.repository.interfaces;

import com.kodigo.facturacion.persistence.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByNombre(String nombre);



}
