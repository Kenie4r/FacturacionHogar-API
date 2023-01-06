package com.kodigo.facturacion.controller;

import com.kodigo.facturacion.persistence.Casa;
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
@AllArgsConstructor
public class CasaController {

    private CasaService casaService;

    @PostMapping()
    public ResponseEntity<Casa> guardarCasa(@RequestBody Casa casa){
        return new ResponseEntity<Casa>(casaService.guardarCasa(casa), HttpStatus.CREATED);
    }

    @PostMapping()
    public ResponseEntity<Casa> guardarCasa(@RequestBody String numeroCasa, Double costoMantenimiento, Long codigoPropietario,
                                            Long codigoDepartamento, Long codigoPais, Long codigoMunicipio){
        return new ResponseEntity<Casa>(casaService.guardarCasa(casa), HttpStatus.CREATED);
    }
}
