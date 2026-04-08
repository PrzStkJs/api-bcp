package com.bcp.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "CAT_TIPO_TARJETA")
public class CAT_TIPO_TARJETA {

    @Id
    @Column(name = "TTJ_N_ID")
    @JsonProperty("TTJ_N_ID")
    private int TTJ_N_ID;

    @Column(name = "TTJ_V_NOMBRE")
    @JsonProperty("TTJ_V_NOMBRE")
    private String TTJ_V_NOMBRE;

    @Column(name = "TTJ_V_DESCRIPCION")
    @JsonProperty("TTJ_V_DESCRIPCION")
    private String TTJ_V_DESCRIPCION;

    @Column(name = "TTJ_V_ESTADO")
    @JsonProperty("TTJ_V_ESTADO")
    private String TTJ_V_ESTADO;

    public CAT_TIPO_TARJETA() {}

    public CAT_TIPO_TARJETA(int TTJ_N_ID, String TTJ_V_NOMBRE, String TTJ_V_DESCRIPCION, String TTJ_V_ESTADO) {
        this.TTJ_N_ID = TTJ_N_ID;
        this.TTJ_V_NOMBRE = TTJ_V_NOMBRE;
        this.TTJ_V_DESCRIPCION = TTJ_V_DESCRIPCION;
        this.TTJ_V_ESTADO = TTJ_V_ESTADO;
    }

    public int getTTJ_N_ID() { return TTJ_N_ID; }
    public void setTTJ_N_ID(int tTJ_N_ID) { TTJ_N_ID = tTJ_N_ID; }

    public String getTTJ_V_NOMBRE() { return TTJ_V_NOMBRE; }
    public void setTTJ_V_NOMBRE(String tTJ_V_NOMBRE) { TTJ_V_NOMBRE = tTJ_V_NOMBRE; }

    public String getTTJ_V_DESCRIPCION() { return TTJ_V_DESCRIPCION; }
    public void setTTJ_V_DESCRIPCION(String tTJ_V_DESCRIPCION) { TTJ_V_DESCRIPCION = tTJ_V_DESCRIPCION; }

    public String getTTJ_V_ESTADO() { return TTJ_V_ESTADO; }
    public void setTTJ_V_ESTADO(String tTJ_V_ESTADO) { TTJ_V_ESTADO = tTJ_V_ESTADO; }
}