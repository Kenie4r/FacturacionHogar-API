package com.kodigo.facturacion.controller;


import com.kodigo.facturacion.persistence.Factura;
import com.kodigo.facturacion.service.FacturaImpl;
import com.kodigo.facturacion.service.ProveedorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/factura")
public class FacturaContoller {

    @Autowired
    FacturaImpl facturaImpl;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Factura>> listarFacturas(){
        return new ResponseEntity<>(facturaImpl.listadoDeFacturas(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> guardarFactura(@RequestBody Factura factura){
        String message = facturaImpl.guardarFactura(factura);
        if(message.equals("Can't save")){
            throw  new RuntimeException("No se pudo guardar la factura");
        }
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }
    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public ResponseEntity<Factura> obtenerFactura(@PathVariable Long id){
        Factura factura = facturaImpl.obtenerFacturaPorCodigo(id);
        if(factura==null){
            throw new RuntimeException("Id de factura inexistente");
        }
        return new ResponseEntity<>(factura, HttpStatus.OK);
    }

    @RequestMapping(value = "eliminar/{idd}", method = RequestMethod.DELETE)
    public ResponseEntity<String> eliminarFactura(@PathVariable Long id){
        String message = facturaImpl.eliminarFactura(id);
        if(message.equals("Can't delete")){
            throw  new RuntimeException("No se pudo eliminar la factura");
        }
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public  ResponseEntity<String> actualizarFactura(@PathVariable Long id, @RequestBody Factura factura){
        String message = facturaImpl.actualizarFactura(factura, id);
        if(message.equals("Can't delete it")){
            throw new RuntimeException("No se pudo actualizar la factura");
        }
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
