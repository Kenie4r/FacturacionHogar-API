package com.kodigo.facturacion.controller;

import com.kodigo.facturacion.persistence.Casa;
import com.kodigo.facturacion.requestbody.AnadirCasa;
import com.kodigo.facturacion.service.interfaces.CasaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/casa")
public class CasaController {

    private CasaService casaService;

    public CasaController(CasaService casaService) {
        super();
        this.casaService = casaService;
    }

    @PostMapping()
    public ResponseEntity<Casa> guardarCasa(@RequestBody Casa casa){
        return new ResponseEntity<Casa>(casaService.guardarCasa(casa), HttpStatus.CREATED);
    }

    @PostMapping("/agregar")
    public ResponseEntity<Casa> guardarCasaConIds(@RequestBody AnadirCasa anadirCasa){
        return new ResponseEntity<Casa>(casaService.guardarCasa(anadirCasa), HttpStatus.CREATED);
    }
}
