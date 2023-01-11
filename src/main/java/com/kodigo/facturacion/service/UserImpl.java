package com.kodigo.facturacion.service;

import com.kodigo.facturacion.persistence.Usuario;
import com.kodigo.facturacion.repository.interfaces.UserRepository;
import com.kodigo.facturacion.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
