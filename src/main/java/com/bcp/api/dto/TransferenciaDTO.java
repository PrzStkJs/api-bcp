package com.bcp.api.dto;

import java.math.BigDecimal;

public class TransferenciaDTO {
    public String cuentaOrigen;
    public String cuentaDestino;
    public BigDecimal monto;
    public int moneda; 
    public String referencia;
    public boolean esTercero;

    public TransferenciaDTO() {}

    public TransferenciaDTO(String cuentaOrigen, String cuentaDestino, BigDecimal monto, 
                            int moneda, String referencia, boolean esTercero) {
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
        this.monto = monto;
        this.moneda = moneda; // Ahora es un número
        this.referencia = referencia;
        this.esTercero = esTercero;
    }
}