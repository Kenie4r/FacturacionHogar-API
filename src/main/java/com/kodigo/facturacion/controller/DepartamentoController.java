package com.kodigo.facturacion.controller;

import com.kodigo.facturacion.persistence.Departamento;
import com.kodigo.facturacion.service.DepartamentoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("api/departamento")
public class DepartamentoController {

    @Autowired
    DepartamentoImpl department;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Departamento>> listOfDepartment(){
        return new ResponseEntity<List<Departamento>>(department.getDepartment(),HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Departamento> getDepartment (@PathVariable("id") Long id) throws Exception{
        return new ResponseEntity<Departamento>(department.getDepartmentByID(id),HttpStatus.FOUND);
    }

    @RequestMapping(method = RequestMethod.POST)
    public  ResponseEntity<String> saveDepartment(@RequestBody Departamento departmentN){
        return new ResponseEntity<String>(department.saveDepartment(departmentN),HttpStatus.CREATED);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteDepartment(@PathVariable Long id) throws Exception{
        return new ResponseEntity<String>(department.deleteDepartment(id),HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateDepartment(@PathVariable Long id, @RequestBody Departamento department1){
        department1.setCodigoDepartamento(id);
        String message = department.updateDepartment(department1);
        if(message.equals("Can't delete it")){
            throw new RuntimeException("No se pudo actualizar registro");
        }
        return new ResponseEntity<>(message, HttpStatus.OK);
    }


}
