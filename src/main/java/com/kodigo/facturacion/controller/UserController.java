package com.kodigo.facturacion.controller;

import com.kodigo.facturacion.persistence.Usuario;
import com.kodigo.facturacion.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/loggin")
public class UserController {

    @Autowired
    UserService user;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Usuario> getUser (@PathVariable("id") Long id) throws Exception{
        return new ResponseEntity<Usuario>(user.BuscarUsuarioById(id), HttpStatus.FOUND);
    }

}
