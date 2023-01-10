package com.kodigo.facturacion.service;

import com.kodigo.facturacion.persistence.Factura;
import com.kodigo.facturacion.repository.interfaces.FacturaRepository;
import com.kodigo.facturacion.service.interfaces.FacturaService;
import org.hibernate.sql.exec.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaImpl implements FacturaService {
    @Autowired
    FacturaRepository repository;

    @Override
    public String guardarFactura(Factura factura) {
        try {
            repository.save(factura);
        } catch (Exception exception) {
            return "Can't save";
        }
        return "Saved";
    }

    @Override
    public String eliminarFactura(Long id) {

        try {
            Optional<Factura> facturaOptional = repository.findById(id);
            if (facturaOptional.isPresent()) {
                Factura factura = facturaOptional.get();
                repository.delete(factura);
                return "Deleted";
            }
            return "Can't delete";
        } catch (Exception e) {
            return "Can't delete";
        }
    }

    @Override
    public String actualizarFactura(Factura baseFactura, Long id) {
        try {
            Optional<Factura> facturaOptional = repository.findById(id);
            if (facturaOptional.isPresent()) {
                Factura fct = facturaOptional.get();
                fct.setServicio(baseFactura.getServicio());
                fct.setTotal(baseFactura.getTotal());
                fct.setFechaExpidacion(baseFactura.getFechaExpidacion());


                repository.save(fct);

                return "Update";
            }
            return "Can't update";

        } catch (Exception e) {
            return "Can't update";
        }
    }

    @Override
    public Factura obtenerFacturaPorCodigo(Long id) {
        try{
            Optional<Factura> facturaOptional = repository.findById(id);
            if(facturaOptional.isPresent()){
                return facturaOptional.get();
            }
            return null;
        }catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Factura> listadoDeFacturas() {
        return repository.findAll();
    }

    @Override
    public List<Factura> listadoDeFacturasSerivicio(Long id) {
        return  repository.getFacturaByServicio(id);
    }
}
