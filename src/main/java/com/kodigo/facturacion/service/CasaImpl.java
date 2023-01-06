package com.kodigo.facturacion.service;

import com.kodigo.facturacion.exception.ResourceNotFoundException;
import com.kodigo.facturacion.persistence.*;
import com.kodigo.facturacion.repository.interfaces.*;
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
    public Casa guardarCasa(String numeroCasa, Double costoMantenimiento, Long codigoPropietario,
                            Long codigoDepartamento, Long codigoPais, Long codigoMunicipio) {

        Propietario propietario = propietarioRepository.findById(codigoPropietario).orElseThrow(() ->
                new ResourceNotFoundException("Propietario","Id",codigoPropietario));

        Pais pais = paisRepository.findById(codigoPais).orElseThrow(() ->
                new ResourceNotFoundException("Pais","Id",codigoPais));

        Departamento departamento = departamentoRepository.findById(codigoDepartamento).orElseThrow(()->
                new ResourceNotFoundException("Departamento", "Id",codigoDepartamento));

        Municipio municipio = municipioRepository.findById(codigoMunicipio).orElseThrow(()->
                new ResourceNotFoundException("Municipio","Id",codigoMunicipio));

        Casa casa = new Casa();
        casa.setNumeroCasa(numeroCasa);
        casa.setCostoMantenimiento(costoMantenimiento);
        casa.setPropietario(propietario);
        casa.setPais(pais);
        casa.setDepartamento(departamento);
        casa.setMunicipio(municipio);

        return guardarCasa(casa);
    }

}
