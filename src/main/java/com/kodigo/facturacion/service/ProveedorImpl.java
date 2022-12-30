package com.kodigo.facturacion.service;

import com.kodigo.facturacion.persistence.Proveedor;
import com.kodigo.facturacion.repository.interfaces.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorImpl{
    @Autowired
    ProveedorRepository proveedorRepository;

    public List<Proveedor> obtenerProveedores(){
        return proveedorRepository.findAll();
    }
}
