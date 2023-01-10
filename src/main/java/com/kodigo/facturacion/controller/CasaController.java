package com.kodigo.facturacion.controller;

import com.kodigo.facturacion.persistence.Casa;
import com.kodigo.facturacion.persistence.Habitante;
import com.kodigo.facturacion.requestbody.AnadirCasa;
import com.kodigo.facturacion.service.interfaces.CasaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("{id}")
    public ResponseEntity<Casa> cargarCasaPorId(@PathVariable("id") long casaId){
        return new ResponseEntity<Casa>(casaService.cargarCasaPorId(casaId),HttpStatus.OK);
    }

    @PostMapping("{id}/nuevohabitante")
    public ResponseEntity<Habitante> guardarHabitante(@PathVariable("id") long casaId,@RequestBody Habitante habitante){
        return new ResponseEntity<Habitante>(casaService.guardarHabitante(casaId,habitante),HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarCasa(@PathVariable("id") long id){
        casaService.eliminarCasa(id);
        return new ResponseEntity<String>("Casa Eliminada Exitosamente",HttpStatus.OK);
    }
}
