package com.kodigo.facturacion.service;

import com.kodigo.facturacion.exception.ResourceNotFoundException;
import com.kodigo.facturacion.persistence.Casa;
import com.kodigo.facturacion.persistence.Proveedor;
import com.kodigo.facturacion.persistence.Servicio;
import com.kodigo.facturacion.repository.interfaces.CasaRepository;
import com.kodigo.facturacion.repository.interfaces.ProveedorRepository;
import com.kodigo.facturacion.repository.interfaces.ServicioRepository;
import com.kodigo.facturacion.requestbody.CuerpoServicio;
import com.kodigo.facturacion.service.interfaces.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioImpl implements ServicioService {

    @Autowired
     private ServicioRepository servicioRepository;
    @Autowired
    private ProveedorRepository proveedorRepository;
    @Autowired
    private CasaRepository casaRepository;

    public ServicioImpl(ServicioRepository servicioRepository,
                        ProveedorRepository proveedorRepository,
                        CasaRepository casaRepository) {
        super();
        this.servicioRepository = servicioRepository;
        this.proveedorRepository = proveedorRepository;
        this.casaRepository = casaRepository;
    }

    @Override
    public Servicio guardarServicio(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    @Override
    public Servicio guardarServicio(CuerpoServicio cuerpoServicio) {
        Servicio servicio = new Servicio();
        servicio.setNombreServicio(cuerpoServicio.getNombreServicio());
        servicio.setTarifa(cuerpoServicio.getTarifa());
        servicio.setFechaSuspencion(cuerpoServicio.getFechaSuspencion());
         Proveedor proveedor = proveedorRepository.findById(cuerpoServicio.getCodigoProveedor())
                 .orElseThrow(()->
                         new ResourceNotFoundException("Proveedor","Id", cuerpoServicio.getCodigoServicio()));
         servicio.setProveedor(proveedor);
         Casa casa = casaRepository.findById(cuerpoServicio.getCodigoCasa())
                 .orElseThrow(()->
                         new ResourceNotFoundException("Casa","Id",cuerpoServicio.getCodigoCasa()));
         servicio.setCasa(casa);
        return guardarServicio(servicio);
    }

    @Override
    public Servicio cargarServicioPorId(Long servicioId) {
        return servicioRepository.findById(servicioId)
                .orElseThrow(()->
                        new ResourceNotFoundException("Servicio", "Id",servicioId));
    }

    @Override
    public void eliminarServicio(Long servicioId) {
        cargarServicioPorId(servicioId);
        servicioRepository.deleteById(servicioId);
    }

    @Override
    public Servicio actualizarServicio(Long servicioId, CuerpoServicio cuerpoServicio) {
        Servicio servicioOriginal = cargarServicioPorId(servicioId);
        servicioOriginal.setNombreServicio(cuerpoServicio.getNombreServicio());
        servicioOriginal.setTarifa(cuerpoServicio.getTarifa());
        servicioOriginal.setFechaSuspencion(cuerpoServicio.getFechaSuspencion());
        Proveedor proveedor = proveedorRepository.findById(cuerpoServicio.getCodigoProveedor())
                .orElseThrow(()->
                        new ResourceNotFoundException("Proveedor","Id", cuerpoServicio.getCodigoServicio()));
        servicioOriginal.setProveedor(proveedor);
        Casa casa = casaRepository.findById(cuerpoServicio.getCodigoCasa())
                .orElseThrow(()->
                        new ResourceNotFoundException("Casa","Id",cuerpoServicio.getCodigoCasa()));
        servicioOriginal.setCasa(casa);
        return guardarServicio(servicioOriginal);
    }

    @Override
    public List<Servicio> obtenerServiciosPorCasa(Long id) {
        return servicioRepository.getServiciosByCasa(id);
    }
}
