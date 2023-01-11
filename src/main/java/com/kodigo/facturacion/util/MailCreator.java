package com.kodigo.facturacion.util;


import com.kodigo.facturacion.persistence.Cargo;
import com.kodigo.facturacion.persistence.Factura;
import com.kodigo.facturacion.service.MailImpl;
import com.kodigo.facturacion.service.MailImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class MailCreator implements MailCreatorInterface {
    MailImpl mail = new MailImpl();

    @Override
    public String CuerpoDeCorreo(Factura factura) {

        String htmlBODY = "<html>" +
                "<body>" +
                "<h2>FACTURA DE SERVICIO: " +factura.getServicio().getProveedor().getNombreProveedor()+ "</h2>" +
                "<p>Hola cliente, por este medio te compartimos las facturas de tu hogar," +
                " recuerda que puedes pagar estos servicios en las ventanillas del banco, etc. </p>" +
                "<table> <caption>Factura de "+factura.getServicio().getNombreServicio()+"</caption><thead><tr><th>Nombre de cargo </th> <th>Coste </th></tr></thead>";
        for(Cargo cargo : factura.getCargos()){
            htmlBODY+="<tr><td>"+cargo.getNombreCargo()+"</td><td>"+cargo.getMonto()+"</td></tr>";
        }
        htmlBODY+="<tr><td>Total: </td><td>"+factura.getTotal()+"</td></tr>";

        htmlBODY+="</table>     </body>" +
                "</html>";
//      Call the mail request function in order to send the email
        return htmlBODY;
    }
}



