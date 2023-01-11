package com.kodigo.facturacion.service;

import com.kodigo.facturacion.persistence.Factura;
import com.kodigo.facturacion.service.interfaces.MailService;
import com.kodigo.facturacion.util.MailCreator;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailImpl implements MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public boolean setDatosdeCorreo(Factura factura){
        MailCreator mailCreator = new MailCreator();
        String cuerpo = mailCreator.CuerpoDeCorreo(factura);
        String correo = factura.getServicio().getCasa().getPropietario().getCorreo();
        return enviarCorreo(correo, cuerpo);
    }



    @Override
    public boolean enviarCorreo(String receptor, String cuerpo) {
        try{
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();

            MimeMessageHelper mailMessage = new MimeMessageHelper(mimeMessage);
            mailMessage.setTo(receptor);
            mailMessage.setFrom("cuentakodigodummy@gmail.com");
            mailMessage.setSubject("Factura de servicio");
            mailMessage.setText(cuerpo, true);
            javaMailSender.send(mimeMessage);
            return true;

        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return false;

        }

    }
}
