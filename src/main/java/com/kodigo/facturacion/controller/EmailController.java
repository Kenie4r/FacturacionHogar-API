package com.kodigo.facturacion.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;

@RestController
@RequestMapping("/api/email")
public class EmailController {
    @RequestMapping(value = "factura/{id}", method = RequestMethod.GET)
    public ResponseEntity<String> enviarCorreoDeFactura(long id){

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
