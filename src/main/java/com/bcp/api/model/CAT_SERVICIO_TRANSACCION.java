package com.bcp.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "CAT_SERVICIO_TRANSACCION")
public class CAT_SERVICIO_TRANSACCION {

    @Id
    @Column(name = "STX_N_ID")
    @JsonProperty("STX_N_ID")
    private int STX_N_ID;

    @Column(name = "STX_V_NOMBRE")
    @JsonProperty("STX_V_NOMBRE")
    private String STX_V_NOMBRE;

    @Column(name = "STX_V_DESCRIPCION")
    @JsonProperty("STX_V_DESCRIPCION")
    private String STX_V_DESCRIPCION;

    @Column(name = "STX_V_ESTADO")
    @JsonProperty("STX_V_ESTADO")
    private String STX_V_ESTADO;

    public CAT_SERVICIO_TRANSACCION() {}

    public CAT_SERVICIO_TRANSACCION(int STX_N_ID, String STX_V_NOMBRE, String STX_V_DESCRIPCION, String STX_V_ESTADO) {
        this.STX_N_ID = STX_N_ID;
        this.STX_V_NOMBRE = STX_V_NOMBRE;
        this.STX_V_DESCRIPCION = STX_V_DESCRIPCION;
        this.STX_V_ESTADO = STX_V_ESTADO;
    }

    public int getSTX_N_ID() { return STX_N_ID; }
    public void setSTX_N_ID(int sTX_N_ID) { STX_N_ID = sTX_N_ID; }

    public String getSTX_V_NOMBRE() { return STX_V_NOMBRE; }
    public void setSTX_V_NOMBRE(String sTX_V_NOMBRE) { STX_V_NOMBRE = sTX_V_NOMBRE; }

    public String getSTX_V_DESCRIPCION() { return STX_V_DESCRIPCION; }
    public void setSTX_V_DESCRIPCION(String sTX_V_DESCRIPCION) { STX_V_DESCRIPCION = sTX_V_DESCRIPCION; }

    public String getSTX_V_ESTADO() { return STX_V_ESTADO; }
    public void setSTX_V_ESTADO(String sTX_V_ESTADO) { STX_V_ESTADO = sTX_V_ESTADO; }
}