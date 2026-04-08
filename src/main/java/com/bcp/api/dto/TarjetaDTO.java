package com.bcp.api.dto;

public class TarjetaDTO {
    // Datos principales de T_TARJETA
    public String numero;       // TAR_V_NUMERO
    public double saldo;        // TAR_N_SALDO
    public String marcaNombre;  // De CAT_MARCA_TARJETA
    public String tipoNombre;   // De CAT_TIPO_TARJETA

    public TarjetaDTO() {}

    public TarjetaDTO(String numero, double saldo, String marcaNombre, String tipoNombre) {
        this.numero = numero;
        this.saldo = saldo;
        this.marcaNombre = marcaNombre;
        this.tipoNombre = tipoNombre;
    }
}