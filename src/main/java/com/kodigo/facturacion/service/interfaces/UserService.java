package com.kodigo.facturacion.service.interfaces;

import com.kodigo.facturacion.persistence.Usuario;

import java.util.List;

public interface UserService {
    Usuario BuscarUsuarioByName(String name);

    String guardarUsuario(Usuario usuario);

    String eliminarUsuario(Long id);

    String actualizarUsuario(Usuario usuario);

    List<Usuario> obtenerUsuarios();


}
