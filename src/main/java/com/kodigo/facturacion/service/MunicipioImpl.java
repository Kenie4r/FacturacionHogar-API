package com.kodigo.facturacion.service;

import com.kodigo.facturacion.exception.ResourceNotFoundException;
import com.kodigo.facturacion.persistence.Departamento;
import com.kodigo.facturacion.persistence.Habitante;
import com.kodigo.facturacion.persistence.Municipio;
import com.kodigo.facturacion.repository.interfaces.DepartamentoRepository;
import com.kodigo.facturacion.repository.interfaces.MunicipioRepository;
import com.kodigo.facturacion.requestbody.CuerpoMunicipio;
import com.kodigo.facturacion.service.interfaces.MunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MunicipioImpl implements MunicipioService {
    @Autowired
    private MunicipioRepository municipioRepository;
    @Autowired
    private DepartamentoRepository departamentoRepository;

    public MunicipioImpl(MunicipioRepository municipioRepository, DepartamentoRepository departamentoRepository) {
        super();
        this.municipioRepository = municipioRepository;
        this.departamentoRepository = departamentoRepository;
    }

    @Override
    public Municipio anadirMunicipio(Municipio municipio) {
        return municipioRepository.save(municipio);
    }

    @Override
    public Municipio anadirMunicipio(CuerpoMunicipio cuerpoMunicipio) {
        Departamento departamento = departamentoRepository.findById(cuerpoMunicipio.getCodigoDepartamento())
                .orElseThrow(()->
                        new ResourceNotFoundException("Departamento","Id",cuerpoMunicipio.getCodigoDepartamento()));
        Municipio municipio = new Municipio();
        municipio.setNombreMunicipio(cuerpoMunicipio.getNombreMunicipio());
        municipio.setDepartamento(departamento);
        return anadirMunicipio(municipio);
    }

    @Override
    public Municipio cargarMunicipioPorId(Long municipioId) {
        return municipioRepository.findById(municipioId)
                .orElseThrow(()->
                        new ResourceNotFoundException("Municipio","Id",municipioId));
    }

    @Override
    public void eliminarMunicipioPorId(Long municipioId) {
        cargarMunicipioPorId(municipioId);
        municipioRepository.deleteById(municipioId);
    }

    @Override
    public Municipio actualizarMunicipio(Long municipioId, CuerpoMunicipio cuerpoMunicipio) {
        Municipio municipioOriginal = cargarMunicipioPorId(municipioId);
        municipioOriginal.setNombreMunicipio(cuerpoMunicipio.getNombreMunicipio());
        Departamento departamento = departamentoRepository.findById(cuerpoMunicipio.getCodigoDepartamento())
                .orElseThrow(()->
                        new ResourceNotFoundException("Departamento","Id",cuerpoMunicipio.getCodigoDepartamento()));
        municipioOriginal.setDepartamento(departamento);
        return anadirMunicipio(municipioOriginal);
    }
}
