package com.kodigo.facturacion.util;

import com.kodigo.facturacion.persistence.Factura;

public interface MailCreatorInterface {

    public boolean CuerpoDeCorreo(Factura factura, String correo);
    public boolean makeRequestForMail(String body, String correo);
}
