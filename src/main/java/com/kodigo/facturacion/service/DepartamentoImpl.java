package com.kodigo.facturacion.service;

import com.kodigo.facturacion.persistence.Departamento;
import com.kodigo.facturacion.repository.interfaces.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoImpl {

    @Autowired
    DepartamentoRepository departamentoRepository;

    public List<Departamento> getDepartment(){
        return departamentoRepository.findAll();
    }

    public Departamento getDepartmentByID(Long id) throws Exception {
        Optional<Departamento> department = departamentoRepository.findById(id);
        if(!department.isPresent()){
            throw new Exception();
        }
        return department.get();
    }

    public String saveDepartment(Departamento department) {
        if(departamentoRepository.save(department)!=null){
            return "SAVED";
        }
        return "UNSAVED";
    }
    public String deleteDepartment(Long id) throws Exception {
        Optional<Departamento> department = departamentoRepository.findById(id);
        if(!department.isPresent()){
            return "Can't delete it";
        }
        Departamento depa = department.get();
        departamentoRepository.delete(depa);
        return "Deleted";
    }
    public String updateDepartment(Departamento depa){
        if(departamentoRepository.save(depa)!=null){
            return "Saved";
        }
        return "Unsaved";
    }
}
