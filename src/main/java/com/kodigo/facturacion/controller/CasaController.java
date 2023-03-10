package com.kodigo.facturacion.controller;

import com.kodigo.facturacion.persistence.Casa;
import com.kodigo.facturacion.persistence.Habitante;
import com.kodigo.facturacion.requestbody.CuerpoCasa;
import com.kodigo.facturacion.service.interfaces.CasaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/casa")
public class CasaController {

    private CasaService casaService;

    public CasaController(CasaService casaService) {
        super();
        this.casaService = casaService;
    }

    @GetMapping()
    public ResponseEntity<List<Casa>> listadoCasa(){
        return new ResponseEntity<List<Casa>>(casaService.listadoCasa(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Casa> guardarCasa(@RequestBody Casa casa){
        return new ResponseEntity<Casa>(casaService.guardarCasa(casa), HttpStatus.CREATED);
    }

    @PostMapping("/agregar")
    public ResponseEntity<Casa> guardarCasaConIds(@RequestBody CuerpoCasa cuerpoCasa){
        return new ResponseEntity<Casa>(casaService.guardarCasa(cuerpoCasa), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Casa> cargarCasaPorId(@PathVariable("id") long casaId){
        return new ResponseEntity<Casa>(casaService.cargarCasaPorId(casaId),HttpStatus.OK);
    }

    @PostMapping("{id}/nuevohabitante")
    public ResponseEntity<Habitante> guardarHabitante(@PathVariable("id") long casaId,@RequestBody Habitante habitante){
        return new ResponseEntity<Habitante>(casaService.guardarHabitante(casaId,habitante),HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarCasa(@PathVariable("id") long id){
        casaService.eliminarCasa(id);
        return new ResponseEntity<String>("Casa Eliminada Exitosamente",HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Casa> actualizarCasa(@PathVariable("id") long id,
                                               @RequestBody CuerpoCasa cuerpoCasa){
        return new ResponseEntity<Casa>(casaService.actualizarCasa(cuerpoCasa,id),HttpStatus.OK);
    }
}
