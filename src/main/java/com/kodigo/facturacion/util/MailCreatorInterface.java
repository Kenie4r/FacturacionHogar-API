package com.kodigo.facturacion.util;

import com.kodigo.facturacion.persistence.Factura;

public interface MailCreatorInterface {

    public String CuerpoDeCorreo(Factura factura);
}
