package com.kodigo.facturacion.service;

import com.kodigo.facturacion.persistence.Usuario;
import com.kodigo.facturacion.repository.interfaces.UserRepository;
import com.kodigo.facturacion.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserImpl implements UserService {

    @Autowired
    UserRepository userRepository;



    @Override
    public Usuario BuscarUsuarioByName(String name) {
        try {
            Optional<Usuario> usuario = userRepository.findByNombre(name);
            if(!usuario.isPresent()){
                throw new Exception();
            }
            return usuario.get();

        }catch (Exception e){
            return null;
        }
    }

    @Override
    public String guardarUsuario(Usuario usuario) {
        try{
            userRepository.save(usuario);
            return "SAVED";
        }catch (Exception ex){
            return "Can't save";
        }
    }

    @Override
    public String eliminarUsuario(Long id) {
        try{
            Optional<Usuario> usuario = userRepository.findById(id);
            if(!usuario.isPresent()){
                return "Can't delete it";
            }
            Usuario usuario1 = usuario.get();
            userRepository.delete(usuario1);
        }catch (Exception exception){
            return "Can't delete it";
        }
        return "Deleted";
    }

    @Override
    public String actualizarUsuario(Usuario usuario) {
        if(userRepository.save(usuario)!=null){
            return "Saved";
        }
        return "Unsaved";
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        return userRepository.findAll();
    }
}
