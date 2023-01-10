package com.kodigo.facturacion.controller;

import com.kodigo.facturacion.persistence.Proveedor;
import com.kodigo.facturacion.service.ProveedorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.sound.sampled.Port;
import java.rmi.server.RemoteRef;
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
        Proveedor proveedor1 = proveedor.obtenerProveedorPorID(id);
        if(proveedor1==null){
               throw new RuntimeException("Id de proveedor no existe");
        }
        return new ResponseEntity<Proveedor>(proveedor1, HttpStatus.FOUND);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> saveProveedor(@RequestBody Proveedor proveedorN){
        String message = proveedor.guardarProveedor(proveedorN);
        if(message.equals("Can't save")){
            throw new RuntimeException("No se ha podido guardar el proveedor");
        }
        return new ResponseEntity<String>(message, HttpStatus.CREATED);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteProveedor(@PathVariable Long id) throws Exception {
        return new ResponseEntity<String>(proveedor.eliminarProveedor(id), HttpStatus.OK);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.PATCH)
    public ResponseEntity<String> updateProveedor(@PathVariable("id") Long id , @RequestBody Proveedor proveedor1){
        proveedor1.setCodigoProveedor(id);
        String message = proveedor.actualizarProveedor(proveedor1);
        if(message.equals("Can't delete it")){
            throw new RuntimeException("No se ha podido eliminar el proveedor");
        }
        return new ResponseEntity<String>(message , HttpStatus.OK);
    }

    @RequestMapping(value = "nombre/{name}", method = RequestMethod.GET)
    public ResponseEntity<List<Proveedor>> obtenerProveedorPorNombre(@PathVariable("name") String name){
        return new ResponseEntity<>(proveedor.obtenerProveedorPorNombre(name), HttpStatus.OK);
    }
}
