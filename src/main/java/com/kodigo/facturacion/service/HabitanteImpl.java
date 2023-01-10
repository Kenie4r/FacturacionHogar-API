package com.kodigo.facturacion.service;

import com.kodigo.facturacion.exception.ResourceNotFoundException;
import com.kodigo.facturacion.persistence.Casa;
import com.kodigo.facturacion.persistence.Habitante;
import com.kodigo.facturacion.repository.interfaces.CasaRepository;
import com.kodigo.facturacion.repository.interfaces.HabitanteRepository;
import com.kodigo.facturacion.requestbody.CuerpoHabitante;
import com.kodigo.facturacion.service.interfaces.HabitanteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class HabitanteImpl implements HabitanteService {
    @Autowired
    HabitanteRepository habitanteRepository;
    @Autowired
    CasaRepository casaRepository;


    @Override
    public Habitante anadirHabitante(Habitante habitante) {
        return habitanteRepository.save(habitante);
    }

    @Override
    public Habitante anadirHabitante(CuerpoHabitante cuerpoHabitante) {
        Habitante habitante = new Habitante();
        habitante.setNombreHabitante(cuerpoHabitante.getNombreHabitante());
        habitante.setCorreo(cuerpoHabitante.getCorreo());
        Casa casa = casaRepository.findById(cuerpoHabitante.getCasaId()).orElseThrow(()->
                new ResourceNotFoundException("Casa","Id",cuerpoHabitante.getCasaId()));
        habitante.setCasa(casa);
        return habitanteRepository.save(habitante);
    }


    @Override
    public Habitante cargarHabitantePorId(Long habitanteId) {
        return habitanteRepository.findById(habitanteId).orElseThrow(()->
                new ResourceNotFoundException("Habitante","Id",habitanteId));
    }

    @Override
    public void eliminarHabitantePorId(Long habitanteId) {
        habitanteRepository.findById(habitanteId).orElseThrow(()->
                new ResourceNotFoundException("Habitante","Id",habitanteId));
        habitanteRepository.deleteById(habitanteId);
    }

    @Override
    public Habitante actualizarHabitante(Long habitanteId, CuerpoHabitante cuerpoHabitante) {
        Habitante habitanteOriginal = cargarHabitantePorId(habitanteId);
        habitanteOriginal.setNombreHabitante(cuerpoHabitante.getNombreHabitante());
        habitanteOriginal.setCorreo(cuerpoHabitante.getCorreo());
        Casa casa = casaRepository.findById(cuerpoHabitante.getCasaId()).orElseThrow(()->
                new ResourceNotFoundException("Casa","Id",cuerpoHabitante.getCasaId()));
        habitanteOriginal.setCasa(casa);
        habitanteRepository.save(habitanteOriginal);
        return cargarHabitantePorId(habitanteId);
    }
}
