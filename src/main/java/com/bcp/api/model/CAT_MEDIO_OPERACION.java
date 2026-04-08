package com.bcp.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "CAT_MEDIO_OPERACION")
public class CAT_MEDIO_OPERACION {

    @Id
    @Column(name = "MOP_N_ID")
    @JsonProperty("MOP_N_ID")
    private int MOP_N_ID;

    @Column(name = "MOP_V_NOMBRE")
    @JsonProperty("MOP_V_NOMBRE")
    private String MOP_V_NOMBRE;

    @Column(name = "MOP_V_DESCRIPCION")
    @JsonProperty("MOP_V_DESCRIPCION")
    private String MOP_V_DESCRIPCION;

    @Column(name = "MOP_V_ESTADO")
    @JsonProperty("MOP_V_ESTADO")
    private String MOP_V_ESTADO;

    public CAT_MEDIO_OPERACION() {}

    public CAT_MEDIO_OPERACION(int MOP_N_ID, String MOP_V_NOMBRE, String MOP_V_DESCRIPCION, String MOP_V_ESTADO) {
        this.MOP_N_ID = MOP_N_ID;
        this.MOP_V_NOMBRE = MOP_V_NOMBRE;
        this.MOP_V_DESCRIPCION = MOP_V_DESCRIPCION;
        this.MOP_V_ESTADO = MOP_V_ESTADO;
    }

    public int getMOP_N_ID() { return MOP_N_ID; }
    public void setMOP_N_ID(int mOP_N_ID) { MOP_N_ID = mOP_N_ID; }

    public String getMOP_V_NOMBRE() { return MOP_V_NOMBRE; }
    public void setMOP_V_NOMBRE(String mOP_V_NOMBRE) { MOP_V_NOMBRE = mOP_V_NOMBRE; }

    public String getMOP_V_DESCRIPCION() { return MOP_V_DESCRIPCION; }
    public void setMOP_V_DESCRIPCION(String mOP_V_DESCRIPCION) { MOP_V_DESCRIPCION = mOP_V_DESCRIPCION; }

    public String getMOP_V_ESTADO() { return MOP_V_ESTADO; }
    public void setMOP_V_ESTADO(String mOP_V_ESTADO) { MOP_V_ESTADO = mOP_V_ESTADO; }
}