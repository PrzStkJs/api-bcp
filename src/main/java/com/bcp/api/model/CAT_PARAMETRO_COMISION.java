package com.bcp.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "CAT_PARAMETRO_COMISION")
public class CAT_PARAMETRO_COMISION {

    @Id
    @Column(name = "PRC_N_ID")
    @JsonProperty("PRC_N_ID")
    private int PRC_N_ID;

    @Column(name = "PRC_V_NOMBRE")
    @JsonProperty("PRC_V_NOMBRE")
    private String PRC_V_NOMBRE;

    @Column(name = "PRC_V_DESCRIPCION")
    @JsonProperty("PRC_V_DESCRIPCION")
    private String PRC_V_DESCRIPCION;

    @Column(name = "PRC_V_ESTADO")
    @JsonProperty("PRC_V_ESTADO")
    private String PRC_V_ESTADO;

    public CAT_PARAMETRO_COMISION() {}

    public CAT_PARAMETRO_COMISION(int PRC_N_ID, String PRC_V_NOMBRE, String PRC_V_DESCRIPCION, String PRC_V_ESTADO) {
        this.PRC_N_ID = PRC_N_ID;
        this.PRC_V_NOMBRE = PRC_V_NOMBRE;
        this.PRC_V_DESCRIPCION = PRC_V_DESCRIPCION;
        this.PRC_V_ESTADO = PRC_V_ESTADO;
    }

    public int getPRC_N_ID() { return PRC_N_ID; }
    public void setPRC_N_ID(int pRC_N_ID) { PRC_N_ID = pRC_N_ID; }

    public String getPRC_V_NOMBRE() { return PRC_V_NOMBRE; }
    public void setPRC_V_NOMBRE(String pRC_V_NOMBRE) { PRC_V_NOMBRE = pRC_V_NOMBRE; }

    public String getPRC_V_DESCRIPCION() { return PRC_V_DESCRIPCION; }
    public void setPRC_V_DESCRIPCION(String pRC_V_DESCRIPCION) { PRC_V_DESCRIPCION = pRC_V_DESCRIPCION; }

    public String getPRC_V_ESTADO() { return PRC_V_ESTADO; }
    public void setPRC_V_ESTADO(String pRC_V_ESTADO) { PRC_V_ESTADO = pRC_V_ESTADO; }
}