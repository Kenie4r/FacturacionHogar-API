package com.kodigo.facturacion.service;

import com.kodigo.facturacion.exception.ResourceNotFoundException;
import com.kodigo.facturacion.persistence.*;
import com.kodigo.facturacion.repository.interfaces.*;
import com.kodigo.facturacion.requestbody.AnadirCasa;
import com.kodigo.facturacion.service.interfaces.CasaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CasaImpl implements CasaService {
    @Autowired
    private CasaRepository casaRepository;
    @Autowired
    private final PropietarioRepository propietarioRepository;
    @Autowired
    private final PaisRepository paisRepository;
    @Autowired
    private final DepartamentoRepository departamentoRepository;
    @Autowired
    private final MunicipioRepository municipioRepository;


    @Override
    public Casa guardarCasa(Casa casa) {
        return casaRepository.save(casa);
    }

    @Override
    public Casa guardarCasa(AnadirCasa anadirCasa) {

        System.out.println(anadirCasa);

        Propietario propietario = propietarioRepository.findById(anadirCasa.codigoPropietario).orElseThrow(() ->
                new ResourceNotFoundException("Propietario","Id",anadirCasa.codigoPropietario));

        Pais pais = paisRepository.findById(anadirCasa.codigoPais).orElseThrow(() ->
                new ResourceNotFoundException("Pais","Id",anadirCasa.codigoPais));

        Departamento departamento = departamentoRepository.findById(anadirCasa.codigoDepartamento).orElseThrow(()->
                new ResourceNotFoundException("Departamento", "Id",anadirCasa.codigoDepartamento));

        Municipio municipio = municipioRepository.findById(anadirCasa.codigoMunicipio).orElseThrow(()->
                new ResourceNotFoundException("Municipio","Id",anadirCasa.codigoMunicipio));

        Casa casa = new Casa();
        casa.setNumeroCasa(anadirCasa.numeroCasa);
        casa.setCostoMantenimiento(anadirCasa.costoMantenimiento);
        casa.setPropietario(propietario);
        casa.setPais(pais);
        casa.setDepartamento(departamento);
        casa.setMunicipio(municipio);

        return guardarCasa(casa);
    }

    @Override
    public Casa cargarCasaPorId(Long id) {
        return casaRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Casa","Id",id));
    }

}
