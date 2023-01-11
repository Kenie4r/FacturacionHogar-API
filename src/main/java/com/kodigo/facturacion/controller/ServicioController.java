package com.kodigo.facturacion.controller;

import com.kodigo.facturacion.persistence.Servicio;
import com.kodigo.facturacion.requestbody.CuerpoCasa;
import com.kodigo.facturacion.requestbody.CuerpoServicio;
import com.kodigo.facturacion.service.interfaces.ServicioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/servicio")
public class ServicioController {
    private ServicioService servicioService;

    public ServicioController(ServicioService servicioService) {
        this.servicioService = servicioService;
    }

    @PostMapping
    public ResponseEntity<Servicio> guardarServicio(@RequestBody Servicio servicio){
        return new ResponseEntity<Servicio>(servicioService.guardarServicio(servicio),HttpStatus.CREATED);
    }

    @PostMapping("/agregar")
    public ResponseEntity<Servicio> guardarServicio(@RequestBody CuerpoServicio cuerpoServicio){
        return new ResponseEntity<Servicio>(servicioService.guardarServicio(cuerpoServicio),HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Servicio> conseguirServicio(@PathVariable("id") long servicioId){
        return new ResponseEntity<Servicio>(servicioService.cargarServicioPorId(servicioId),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarServicio(@PathVariable("id") long servicioId){
        servicioService.eliminarServicio(servicioId);
        return new ResponseEntity<String>("Servicio Eliminado Exitosamente",HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Servicio> actualizarServicio(@PathVariable("id") long servicioId,
                                                       @RequestBody CuerpoServicio cuerpoServicio){
        return new ResponseEntity<Servicio>(servicioService.actualizarServicio(servicioId,cuerpoServicio)
        , HttpStatus.OK);
    }
}
