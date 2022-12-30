package com.kodigo.facturacion.controller;

import com.kodigo.facturacion.persistence.Proveedor;
import com.kodigo.facturacion.service.ProveedorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/proveedor")
public class ProveedorController {
    @Autowired
    ProveedorImpl proveedor;
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Proveedor>> listOfProveedores(){
        return new ResponseEntity<List<Proveedor>>(proveedor.obtenerProveedores(), HttpStatus.OK);
    }

}
