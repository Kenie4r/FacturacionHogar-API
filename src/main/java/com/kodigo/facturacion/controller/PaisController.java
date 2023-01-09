package com.kodigo.facturacion.controller;

import com.kodigo.facturacion.persistence.Departamento;
import com.kodigo.facturacion.persistence.Pais;
import com.kodigo.facturacion.service.PaisImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/país")
public class PaisController {

    @Autowired
    PaisImpl country;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Pais>> listOfCountry(){
        return new ResponseEntity<List<Pais>>(country.getCountry(),HttpStatus.OK);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public  ResponseEntity<Pais> getCountry(@PathVariable("id") Long id) throws  Exception{
        return new ResponseEntity<Pais>(country.getCountryByID(id),HttpStatus.FOUND);
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> saveCountry(@RequestBody Pais countryN){
        return new ResponseEntity<String>(country.saveCountry(countryN),HttpStatus.CREATED);
    }
    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteCountry(@PathVariable Long id) throws Exception {
        return new ResponseEntity<String>(country.deteleCountry(id), HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateCountry(@PathVariable Long id , @RequestBody Pais country1){
        country1.setCodigoPais(id);
        String message = country.updateCountry(country1);
        if (message.equals("Can't delete it")){
            throw  new RuntimeException("No se pudo actualizar registro");
        }

        return new ResponseEntity<String>(message, HttpStatus.OK);
    }



}
