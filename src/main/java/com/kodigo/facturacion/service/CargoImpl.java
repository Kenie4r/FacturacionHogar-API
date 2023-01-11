package com.kodigo.facturacion.service;

import com.kodigo.facturacion.exception.ResourceNotFoundException;
import com.kodigo.facturacion.persistence.Cargo;
import com.kodigo.facturacion.persistence.Factura;
import com.kodigo.facturacion.repository.interfaces.CargoRespository;
import com.kodigo.facturacion.requestbody.CuerpoCargo;
import com.kodigo.facturacion.service.interfaces.CargoService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CargoImpl implements CargoService {

    CargoRespository cargoRespository;


    public CargoImpl(CargoRespository cargoRespository) {
        super();
        this.cargoRespository = cargoRespository;
    }

    @Override
    public Cargo guardarCargo(Cargo cargo) {
        return cargoRespository.save(cargo);
    }

    @Override
    public Cargo guardarCargo(CuerpoCargo cuerpoCargo) {
        Cargo cargo = new Cargo();
        cargo.setNombreCargo(cuerpoCargo.getNombreCargo());
        cargo.setMonto(cuerpoCargo.getMonto());
        Factura factura = new Factura();
        factura.setIdFactura(cuerpoCargo.getFacturaId());
        cargo.setFactura(factura);
        return guardarCargo(cargo);
    }

    @Override
    public List<Cargo> cargarCargoPorFactura(long idFactura) {
        return cargoRespository.findByFactura_IdFactura(idFactura);
    }

    @Override
    public void eliminarCargo(long cargoId) {
        cargoRespository.findById(cargoId)
                .orElseThrow(()->
                        new ResourceNotFoundException("Cargo","Id",cargoId));
        cargoRespository.deleteById(cargoId);
    }

    @Override
    public Cargo actualizarCargo(long cargoId, CuerpoCargo cuerpoCargo) {
        Cargo cargo =  cargoRespository.findById(cargoId)
                .orElseThrow(()->
                        new ResourceNotFoundException("Cargo","Id",cargoId));;
        cargo.setNombreCargo(cuerpoCargo.getNombreCargo());
        cargo.setMonto(cuerpoCargo.getMonto());
        Factura factura = new Factura();
        factura.setIdFactura(cuerpoCargo.getFacturaId());
        cargo.setFactura(factura);
        return guardarCargo(cargo);
    }
}
