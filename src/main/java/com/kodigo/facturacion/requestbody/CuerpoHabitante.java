package com.kodigo.facturacion.requestbody;

import com.kodigo.facturacion.persistence.Casa;
import lombok.Data;

@Data
public class CuerpoHabitante {
    public String nombreHabitante;
    public String correo;
    public Long casaId;
}
