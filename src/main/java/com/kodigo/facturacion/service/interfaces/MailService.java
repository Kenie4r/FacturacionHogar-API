package com.kodigo.facturacion.service.interfaces;

import jakarta.mail.MessagingException;

public interface MailService {
    public boolean enviarCorreo(String receptor, String cuerpo) throws MessagingException;
}
