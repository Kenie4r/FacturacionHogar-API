package com.kodigo.facturacion.controller;

import com.kodigo.facturacion.persistence.Propietario;
import com.kodigo.facturacion.service.interfaces.PropietarioService;
import org.apache.coyote.Response;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/propietario")
public class PropietarioController {

    private PropietarioService propietarioService;

    public PropietarioController(PropietarioService propietarioService) {
        super();
        this.propietarioService = propietarioService;
    }

    @PostMapping("/agregar")
    public ResponseEntity<Propietario> guardarPropietario(@RequestBody Propietario propietario){
        return new ResponseEntity<Propietario>(propietarioService.guardarPropetario(propietario), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Propietario> cargarPropietarioPorId(@PathVariable("id") Long propietarioId){
        return new ResponseEntity<Propietario>(propietarioService.conseguirPropetarioPorId(propietarioId), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarPropietario(@PathVariable("id") Long propietarioId){
        propietarioService.eliminarPropietario(propietarioId);
        return new ResponseEntity<String>("Propietario Eliminado Exitosamente", HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Propietario> actualizarPropietario(@PathVariable("id") Long propietarioId,
                                                             @RequestBody Propietario propietario){
        return new ResponseEntity<Propietario>(propietarioService.actualizarPropietario(propietario,propietarioId),
                HttpStatus.OK);
    }
}
