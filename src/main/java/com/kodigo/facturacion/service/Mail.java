package com.kodigo.facturacion.service;

import com.kodigo.facturacion.persistence.Casa;
import com.kodigo.facturacion.persistence.Propietario;
import lombok.Getter;
import lombok.Setter;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


public class Mail {
    @Getter @Setter
    private String port;
    @Getter @Setter
    private String host;
    @Getter @Setter
    private boolean enable;
    @Getter @Setter
    private boolean auth;

    @Getter @Setter
    private String user;
    @Getter @Setter
    private String pass;

    @Getter @Setter
    private String addressee;

    public Mail(String correo){
        this.auth=true;
        this.host="smtp.gmail.com";
        this.port="587";
        this.enable=true;
        this.user="cuentakodigodummy@gmail.com";
        this.pass = "bsauwaphgbftybwz";
        this.addressee= correo;
    }



    public Session crearsesion(){
        Session session = Session.getInstance(crearPropiedades(),
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user, pass);
                    }
                });

        return session;
    }

    public Properties crearPropiedades(){
        Properties props = new Properties();
        props.put("mail.smtp.auth", this.auth);
        props.put("mail.smtp.starttls.enable", this.enable);
        props.put("mail.smtp.host", this.host);
        props.put("mail.smtp.port", this.port);
        props.put("mail.smtp.ssl.trust", this.host);
        return props;
    }

    public boolean sendemail(String body) {
        boolean exito = false;
        try {
            Message message = new MimeMessage(crearsesion());
            message.setFrom(new InternetAddress(getUser()));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(this.addressee));
            message.setSubject("Recibo");
            message.setContent(body, "text/html");
            Transport.send(message);
            System.out.println("Correo Enviado Exitosamente");
            exito = true;
        } catch (MessagingException e) {
            System.out.println("Antivirus o Firewall Blockea Envio de Correos");
        }
        return exito;
    }
}
