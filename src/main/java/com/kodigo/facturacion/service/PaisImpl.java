package com.kodigo.facturacion.service;

import com.kodigo.facturacion.persistence.Pais;
import com.kodigo.facturacion.repository.interfaces.PaisRepository;
import com.kodigo.facturacion.service.interfaces.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaisImpl implements  PaisService {
    @Autowired
    PaisRepository paisRepository;

    public List<Pais> getCountry(){
        return  paisRepository.findAll();
    }

    public  Pais getCountryByID(long id) throws Exception{

            Optional<Pais> country = paisRepository.findById(id);
            if(!country.isPresent()){
                throw  new Exception();
            }
            return country.get();


    }

    public String saveCountry(Pais country){


            if(paisRepository.save(country)!=null) {
               return "saved";
            }

            return "Unsave";

    }


    public String deteleCountry (long id) throws Exception{

            Optional<Pais> country = paisRepository.findById(id);
            if(!country.isPresent()){
                return  "We can´t delete it";
            }
            Pais country1 = country.get();
            paisRepository.delete(country1);
            return  "Deleted";

    }
    public String updateCountry(Pais country){
        if(paisRepository.save(country)!=null){
            return "Saved";
        }
        return "Unsaved";
        }
    }

