package com.kodigo.facturacion.controller;


import com.kodigo.facturacion.persistence.Factura;
import com.kodigo.facturacion.service.FacturaImpl;
import com.kodigo.facturacion.service.Mail;
import com.kodigo.facturacion.util.MailCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;

@RestController
@RequestMapping("/api/email")
public class EmailController {
    @Autowired
    FacturaImpl facturaImpl;

    @RequestMapping(value = "factura/{id}", method = RequestMethod.GET)
    public ResponseEntity<String> enviarCorreoDeFactura(@PathVariable Long id){
        MailCreator mailCreator = new MailCreator();
        Factura fc = facturaImpl.obtenerFacturaPorCodigo(id);
        if(!mailCreator.CuerpoDeCorreo(fc, fc.getServicio().getCasa().getPropietario().getCorreo())){
            throw new RuntimeException("No se pudo enviar el correo al propietario del hogar");
        }
        return new ResponseEntity<>("Correo enviado!",HttpStatus.OK);
    }
}
