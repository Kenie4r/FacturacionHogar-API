package com.kodigo.facturacion.service;


import com.kodigo.facturacion.service.interfaces.MailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;



@Service
public class Mail implements MailService {

    @Autowired
    private JavaMailSender javaMailSender;


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
            return false;

        }

    }
}
