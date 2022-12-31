package com.kodigo.facturacion.controller;

import com.kodigo.facturacion.persistence.Proveedor;
import com.kodigo.facturacion.service.ProveedorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Proveedor> getProveedor(@PathVariable("id") Long id) throws Exception {
        return new ResponseEntity<Proveedor>(proveedor.obtenerProveedorPorID(id), HttpStatus.FOUND);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> saveProveedor(@RequestBody Proveedor proveedorN){
        return new ResponseEntity<String>(proveedor.guardarProveedor(proveedorN), HttpStatus.CREATED);
    }

}
