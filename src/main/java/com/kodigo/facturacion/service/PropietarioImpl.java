package com.kodigo.facturacion.service;

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
}
