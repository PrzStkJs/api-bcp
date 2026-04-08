package com.bcp.api.dto;

public class SolicitudTarjetaDTO {
    public IdWrapper cuentaBancaria;
    public IdWrapper tipoTarjeta;
    public IdWrapper marcaTarjeta;

    public static class IdWrapper {
        public int cue_n_id;
        public int ttj_n_id;
        public int mar_n_id;
    }
}