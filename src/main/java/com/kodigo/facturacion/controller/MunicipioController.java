package com.kodigo.facturacion.controller;

import com.kodigo.facturacion.persistence.Municipio;
import com.kodigo.facturacion.requestbody.CuerpoMunicipio;
import com.kodigo.facturacion.service.interfaces.MunicipioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/municipio")
public class MunicipioController {
    MunicipioService municipioService;

    public MunicipioController(MunicipioService municipioService) {
        super();
        this.municipioService = municipioService;
    }

    @PostMapping
    public ResponseEntity<Municipio> guardarMunicipio(@RequestBody Municipio municipio){
        return new ResponseEntity<Municipio>(municipioService.anadirMunicipio(municipio), HttpStatus.CREATED);
    }

    @PostMapping("/agregar")
    public ResponseEntity<Municipio> guardarMunicipio(@RequestBody CuerpoMunicipio cuerpoMunicipio){
        return new ResponseEntity<Municipio>(municipioService.anadirMunicipio(cuerpoMunicipio),HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Municipio> cargarMunicipio(@PathVariable("id") Long municipioId){
        return new ResponseEntity<Municipio>(municipioService.cargarMunicipioPorId(municipioId),HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarMunicipio(@PathVariable("id")Long municipioId){
        municipioService.eliminarMunicipioPorId(municipioId);
        return new ResponseEntity<String>("Municipio Elimnado Exitosamente",HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Municipio> actualizarMunicipio(@PathVariable("id") Long municipioId,
                                                         @RequestBody CuerpoMunicipio cuerpoMunicipio){
        return new ResponseEntity<Municipio>(municipioService.actualizarMunicipio(municipioId,cuerpoMunicipio)
        , HttpStatus.OK);
    }
}
