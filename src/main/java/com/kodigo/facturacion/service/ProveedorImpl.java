package com.kodigo.facturacion.service;

import com.kodigo.facturacion.persistence.Proveedor;
import com.kodigo.facturacion.repository.interfaces.ProveedorRepository;
import com.kodigo.facturacion.service.interfaces.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ProveedorImpl implements ProveedorService {
    @Autowired
    ProveedorRepository proveedorRepository;

    public List<Proveedor> obtenerProveedores(){
        return proveedorRepository.findAll();
    }


    public Proveedor obtenerProveedorPorID(Long id) {
        try {
            Optional<Proveedor> proveedor = proveedorRepository.findById(id);
            if(!proveedor.isPresent()){
                throw new Exception();
            }
            return proveedor.get();

        }catch (Exception e){
            return null;
        }
    }

    public String guardarProveedor(Proveedor proveedor) {
        try{
            proveedorRepository.save(proveedor);
            return "SAVED";
        }catch (Exception ex){
            return "Can't save";
        }

    }
    public String eliminarProveedor(Long id) {
        try{
            Optional<Proveedor> proveedor = proveedorRepository.findById(id);
            if(!proveedor.isPresent()){
                return "Can't delete it";
            }
            Proveedor proveedor1 = proveedor.get();
            proveedorRepository.delete(proveedor1);
        }catch (Exception exception){
            return "Can't delete it";
        }

        return "Deleted";
    }
    public String actualizarProveedor(Proveedor proveedor){
        if(proveedorRepository.save(proveedor)!=null){
            return "Saved";
        }
        return "Unsaved";
    }

    @Override
    public List<Proveedor> obtenerProveedorPorNombre(String nombre) {
        String proveedorName = "%" + nombre + "%";
        List<Proveedor> proveedorOptional = proveedorRepository.getProveedorByNombreProveedorContaining(proveedorName);
        if (proveedorOptional.size()>0){
            return proveedorOptional;
        }
        return null;
    }


}
