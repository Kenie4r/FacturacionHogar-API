package com.kodigo.facturacion.service;

import com.kodigo.facturacion.persistence.Proveedor;
import com.kodigo.facturacion.repository.interfaces.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorImpl{
    @Autowired
    ProveedorRepository proveedorRepository;

    public List<Proveedor> obtenerProveedores(){
        return proveedorRepository.findAll();
    }


    public Proveedor obtenerProveedorPorID(Long id) throws Exception {
        Optional<Proveedor> proveedor = proveedorRepository.findById(id);
        if(!proveedor.isPresent()){
            throw new Exception();
        }
        return proveedor.get();
    }

    public String guardarProveedor(Proveedor proveedor) {
        if(proveedorRepository.save(proveedor)!=null){
            return "SAVED";
        }
        return "UNSAVED";
    }
}
