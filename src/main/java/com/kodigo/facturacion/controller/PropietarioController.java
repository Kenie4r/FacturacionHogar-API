package com.kodigo.facturacion.controller;

import com.kodigo.facturacion.persistence.Propietario;
import com.kodigo.facturacion.service.interfaces.PropietarioService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/propietario")
public class PropietarioController {

    private PropietarioService propietarioService;

    public PropietarioController(PropietarioService propietarioService) {
        super();
        this.propietarioService = propietarioService;
    }

    @PostMapping()
    public ResponseEntity<Propietario> guardarPropietario(@RequestBody Propietario propietario){
        return new ResponseEntity<Propietario>(propietarioService.guardarPropetario(propietario), HttpStatus.CREATED);
    }
}
