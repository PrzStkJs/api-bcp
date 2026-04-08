package com.bcp.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "CAT_MONEDA")
public class CAT_MONEDA {

    @Id
    @Column(name = "MON_N_ID")
    @JsonProperty("MON_N_ID")
    private int MON_N_ID;

    @Column(name = "MON_V_NOMBRE")
    @JsonProperty("MON_V_NOMBRE")
    private String MON_V_NOMBRE;

    @Column(name = "MON_V_DESCRIPCION")
    @JsonProperty("MON_V_DESCRIPCION")
    private String MON_V_DESCRIPCION;

    @Column(name = "MON_V_ESTADO")
    @JsonProperty("MON_V_ESTADO")
    private String MON_V_ESTADO;

    public CAT_MONEDA() {}

    public CAT_MONEDA(int MON_N_ID, String MON_V_NOMBRE, String MON_V_DESCRIPCION, String MON_V_ESTADO) {
        this.MON_N_ID = MON_N_ID;
        this.MON_V_NOMBRE = MON_V_NOMBRE;
        this.MON_V_DESCRIPCION = MON_V_DESCRIPCION;
        this.MON_V_ESTADO = MON_V_ESTADO;
    }

    public int getMON_N_ID() { return MON_N_ID; }
    public void setMON_N_ID(int mON_N_ID) { MON_N_ID = mON_N_ID; }

    public String getMON_V_NOMBRE() { return MON_V_NOMBRE; }
    public void setMON_V_NOMBRE(String mON_V_NOMBRE) { MON_V_NOMBRE = mON_V_NOMBRE; }

    public String getMON_V_DESCRIPCION() { return MON_V_DESCRIPCION; }
    public void setMON_V_DESCRIPCION(String mON_V_DESCRIPCION) { MON_V_DESCRIPCION = mON_V_DESCRIPCION; }

    public String getMON_V_ESTADO() { return MON_V_ESTADO; }
    public void setMON_V_ESTADO(String mON_V_ESTADO) { MON_V_ESTADO = mON_V_ESTADO; }
}