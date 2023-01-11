package com.kodigo.facturacion.controller;

import com.kodigo.facturacion.persistence.Cargo;
import com.kodigo.facturacion.requestbody.CuerpoCargo;
import com.kodigo.facturacion.service.interfaces.CargoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cargo")
public class CargoController {
    private CargoService cargoService;

    public CargoController(CargoService cargoService) {
        this.cargoService = cargoService;
    }

    @PostMapping()
    public ResponseEntity<Cargo> guardarCargo(@RequestBody CuerpoCargo cuerpoCargo){
        return new ResponseEntity<Cargo>(cargoService.guardarCargo(cuerpoCargo), HttpStatus.CREATED);
    }

    @GetMapping("/factura/{id}")
    public List<Cargo> cargarCargosPorFactura(@PathVariable("id") Long facturaId){
        return cargoService.cargarCargoPorFactura(facturaId);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarCargo(@PathVariable("id")Long idCargo){
        cargoService.eliminarCargo(idCargo);
        return new ResponseEntity<String>("Cargo Eliminado Exitosamente",HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Cargo> actualizarCargo(@PathVariable("id") long idCargo,
                                                 @RequestBody CuerpoCargo cuerpoCargo){
        return new ResponseEntity<Cargo>(cargoService.actualizarCargo(idCargo,cuerpoCargo),HttpStatus.OK);
    }
}
