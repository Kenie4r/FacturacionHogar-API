package com.kodigo.facturacion.controller;

import com.kodigo.facturacion.persistence.Habitante;
import com.kodigo.facturacion.requestbody.CuerpoHabitante;
import com.kodigo.facturacion.service.interfaces.HabitanteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/habitante")
public class HabitanteController {

    private HabitanteService habitanteService;

    public HabitanteController(HabitanteService habitanteService) {
        super();
        this.habitanteService = habitanteService;
    }

    @PostMapping()
    public ResponseEntity<Habitante> agregarHabitante(@RequestBody Habitante habitante){
        return new ResponseEntity<Habitante>(habitanteService.anadirHabitante(habitante), HttpStatus.CREATED);
    }

    @PostMapping("/agregar")
    public ResponseEntity<Habitante> agregarHabitante(@RequestBody CuerpoHabitante cuerpoHabitante){
        return new ResponseEntity<Habitante>(habitanteService.anadirHabitante(cuerpoHabitante), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Habitante> conseguirHabitante(@PathVariable("id")Long habitanteId){
        return new ResponseEntity<Habitante>(habitanteService.cargarHabitantePorId(habitanteId), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarHabitante(@PathVariable("id")Long habitanteId){
        habitanteService.eliminarHabitantePorId(habitanteId);
        return new ResponseEntity<String>("Habitante Eliminado Exitosamente",HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Habitante> actualizarHabitante(@PathVariable("id") Long habitanteId,
                                                         @RequestBody CuerpoHabitante cuerpoHabitante){
        return new ResponseEntity<Habitante>(habitanteService.actualizarHabitante(habitanteId,cuerpoHabitante),HttpStatus.OK);
    }

}
