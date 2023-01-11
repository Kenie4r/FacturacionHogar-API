package com.kodigo.facturacion.controller;

import com.kodigo.facturacion.persistence.Usuario;
import com.kodigo.facturacion.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loggin")
public class UserController {

    @Autowired
    UserService user;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Usuario> getUser (@PathVariable("id") String id) throws Exception{
        return new ResponseEntity<Usuario>(user.BuscarUsuarioByName(id), HttpStatus.FOUND);
    }


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Usuario>> getUsers () throws Exception{
        return new ResponseEntity<List<Usuario>>(user.obtenerUsuarios(), HttpStatus.FOUND);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> saveUsuario(@RequestBody Usuario usuario){
        String message = user.guardarUsuario(usuario);
        if(message.equals("Can't save")){
            throw new RuntimeException("No se ha podido guardar el usuario");
        }
        return new ResponseEntity<String>(message, HttpStatus.CREATED);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteUser(@PathVariable Long id) throws Exception {
        return new ResponseEntity<String>(user.eliminarUsuario(id), HttpStatus.OK);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateUser(@PathVariable("id") Long id , @RequestBody Usuario usuario){
        usuario.setIdUsuario(id);
        String message = user.actualizarUsuario(usuario);
        if(message.equals("Can't delete it")){
            throw new RuntimeException("No se ha podido eliminar el usuario");
        }
        return new ResponseEntity<String>(message , HttpStatus.OK);
    }




}
