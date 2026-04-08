package com.bcp.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "CAT_TIPO_TRANSACCION")
public class CAT_TIPO_TRANSACCION {

    @Id
    @Column(name = "TTX_N_ID")
    @JsonProperty("TTX_N_ID")
    private int TTX_N_ID;

    @Column(name = "TTX_V_NOMBRE")
    @JsonProperty("TTX_V_NOMBRE")
    private String TTX_V_NOMBRE;

    @Column(name = "TTX_V_DESCRIPCION")
    @JsonProperty("TTX_V_DESCRIPCION")
    private String TTX_V_DESCRIPCION;

    @Column(name = "TTX_V_ESTADO")
    @JsonProperty("TTX_V_ESTADO")
    private String TTX_V_ESTADO;

    public CAT_TIPO_TRANSACCION() {}

    public CAT_TIPO_TRANSACCION(int TTX_N_ID, String TTX_V_NOMBRE, String TTX_V_DESCRIPCION, String TTX_V_ESTADO) {
        this.TTX_N_ID = TTX_N_ID;
        this.TTX_V_NOMBRE = TTX_V_NOMBRE;
        this.TTX_V_DESCRIPCION = TTX_V_DESCRIPCION;
        this.TTX_V_ESTADO = TTX_V_ESTADO;
    }

    public int getTTX_N_ID() { return TTX_N_ID; }
    public void setTTX_N_ID(int tTX_N_ID) { TTX_N_ID = tTX_N_ID; }

    public String getTTX_V_NOMBRE() { return TTX_V_NOMBRE; }
    public void setTTX_V_NOMBRE(String tTX_V_NOMBRE) { TTX_V_NOMBRE = tTX_V_NOMBRE; }

    public String getTTX_V_DESCRIPCION() { return TTX_V_DESCRIPCION; }
    public void setTTX_V_DESCRIPCION(String tTX_V_DESCRIPCION) { TTX_V_DESCRIPCION = tTX_V_DESCRIPCION; }

    public String getTTX_V_ESTADO() { return TTX_V_ESTADO; }
    public void setTTX_V_ESTADO(String tTX_V_ESTADO) { TTX_V_ESTADO = tTX_V_ESTADO; }
}