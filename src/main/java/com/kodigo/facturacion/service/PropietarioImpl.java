package com.kodigo.facturacion.service;

import com.kodigo.facturacion.exception.ResourceNotFoundException;
import com.kodigo.facturacion.persistence.Propietario;
import com.kodigo.facturacion.repository.interfaces.PropietarioRepository;
import com.kodigo.facturacion.service.interfaces.PropietarioService;
import org.springframework.stereotype.Service;

@Service
public class PropietarioImpl implements PropietarioService {

    private PropietarioRepository propietarioRepository;

    public PropietarioImpl(PropietarioRepository propietarioRepository) {
        super();
        this.propietarioRepository = propietarioRepository;
    }

    @Override
    public Propietario guardarPropetario(Propietario propietario) {
        return propietarioRepository.save(propietario);
    }

    @Override
    public Propietario conseguirPropetarioPorId(Long propietarioId) {
        return propietarioRepository.findById(propietarioId).orElseThrow(()->
                new ResourceNotFoundException("Propietario","Id",propietarioId));
    }

    @Override
    public Propietario actualizarPropietario(Propietario propietario, Long propietarioId) {
        Propietario propietarioOriginal = conseguirPropetarioPorId(propietarioId);
        propietarioOriginal.setNombrePersona(propietario.getNombrePersona());
        propietarioOriginal.setCorreo(propietario.getCorreo());
        return guardarPropetario(propietarioOriginal);
    }

    @Override
    public void eliminarPropietario(Long propietarioId) {
        conseguirPropetarioPorId(propietarioId);
        propietarioRepository.deleteById(propietarioId);
    }
}
