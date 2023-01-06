package com.kodigo.facturacion.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorMessage {
    private String errorCode;
    private String message;
}
