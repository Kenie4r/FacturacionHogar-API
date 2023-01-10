package com.kodigo.facturacion.service.interfaces;

import com.kodigo.facturacion.persistence.Usuario;

public interface UserService {
    Usuario BuscarUsuarioById(Long id);
}
