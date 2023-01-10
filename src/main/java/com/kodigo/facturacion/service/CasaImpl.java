package com.kodigo.facturacion.service;

import com.kodigo.facturacion.exception.ResourceNotFoundException;
import com.kodigo.facturacion.persistence.*;
import com.kodigo.facturacion.repository.interfaces.*;
import com.kodigo.facturacion.requestbody.CuerpoCasa;
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
    @Autowired
    private final HabitanteRepository habitanteRepository;


    @Override
    public Casa guardarCasa(Casa casa) {
        return casaRepository.save(casa);
    }

    @Override
    public Casa guardarCasa(CuerpoCasa cuerpoCasa) {

        System.out.println(cuerpoCasa);

        Propietario propietario = propietarioRepository.findById(cuerpoCasa.codigoPropietario).orElseThrow(() ->
                new ResourceNotFoundException("Propietario","Id", cuerpoCasa.codigoPropietario));

        Pais pais = paisRepository.findById(cuerpoCasa.codigoPais).orElseThrow(() ->
                new ResourceNotFoundException("Pais","Id", cuerpoCasa.codigoPais));

        Departamento departamento = departamentoRepository.findById(cuerpoCasa.codigoDepartamento).orElseThrow(()->
                new ResourceNotFoundException("Departamento", "Id", cuerpoCasa.codigoDepartamento));

        Municipio municipio = municipioRepository.findById(cuerpoCasa.codigoMunicipio).orElseThrow(()->
                new ResourceNotFoundException("Municipio","Id", cuerpoCasa.codigoMunicipio));

        Casa casa = new Casa();
        casa.setNumeroCasa(cuerpoCasa.numeroCasa);
        casa.setCostoMantenimiento(cuerpoCasa.costoMantenimiento);
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

    @Override
    public Habitante guardarHabitante(Long casaId, Habitante habitante) {
        Casa casa = cargarCasaPorId(casaId);
        habitante.setCasa(casa);
        return habitanteRepository.save(habitante);
    }

    @Override
    public void eliminarCasa(long id) {
        habitanteRepository.eliminarHabitantesDeCasa(id);
        casaRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Casa","Id",id));
        casaRepository.deleteById(id);
    }

    @Override
    public Casa actualizarCasa(CuerpoCasa cuerpoCasa, long id) {

        Casa casaOriginal = cargarCasaPorId(id);
        casaOriginal.setNumeroCasa(cuerpoCasa.numeroCasa);
        casaOriginal.setCostoMantenimiento(cuerpoCasa.costoMantenimiento);
        Propietario propietario = propietarioRepository.findById(cuerpoCasa.codigoPropietario).orElseThrow(() ->
                new ResourceNotFoundException("Propietario","Id",cuerpoCasa.codigoPropietario));
        casaOriginal.setPropietario(propietario);
        Departamento departamento = departamentoRepository.findById(cuerpoCasa.codigoDepartamento).orElseThrow(()->
                new ResourceNotFoundException("Departamento", "Id",cuerpoCasa.codigoDepartamento));
        casaOriginal.setDepartamento(departamento);
        Pais pais = paisRepository.findById(cuerpoCasa.codigoPais).orElseThrow(() ->
                new ResourceNotFoundException("Pais","Id", cuerpoCasa.codigoPais));
        casaOriginal.setPais(pais);
        Municipio municipio = municipioRepository.findById(cuerpoCasa.codigoMunicipio).orElseThrow(()->
                new ResourceNotFoundException("Municipio","Id", cuerpoCasa.codigoMunicipio));
        casaOriginal.setMunicipio(municipio);
        casaRepository.save(casaOriginal);
        return cargarCasaPorId(id);
    }

}
