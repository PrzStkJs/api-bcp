package com.bcp.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "CAT_PERMISO")
public class CAT_PERMISO {

    @Id
    @Column(name = "PRM_N_ID")
    @JsonProperty("PRM_N_ID")
    private int PRM_N_ID;

    @Column(name = "PRM_V_NOMBRE")
    @JsonProperty("PRM_V_NOMBRE")
    private String PRM_V_NOMBRE;

    @Column(name = "PRM_V_DESCRIPCION")
    @JsonProperty("PRM_V_DESCRIPCION")
    private String PRM_V_DESCRIPCION;

    @Column(name = "PRM_V_ESTADO")
    @JsonProperty("PRM_V_ESTADO")
    private String PRM_V_ESTADO;

    public CAT_PERMISO() {}

    public CAT_PERMISO(int PRM_N_ID, String PRM_V_NOMBRE, String PRM_V_DESCRIPCION, String PRM_V_ESTADO) {
        this.PRM_N_ID = PRM_N_ID;
        this.PRM_V_NOMBRE = PRM_V_NOMBRE;
        this.PRM_V_DESCRIPCION = PRM_V_DESCRIPCION;
        this.PRM_V_ESTADO = PRM_V_ESTADO;
    }

    public int getPRM_N_ID() { return PRM_N_ID; }
    public void setPRM_N_ID(int pRM_N_ID) { PRM_N_ID = pRM_N_ID; }

    public String getPRM_V_NOMBRE() { return PRM_V_NOMBRE; }
    public void setPRM_V_NOMBRE(String pRM_V_NOMBRE) { PRM_V_NOMBRE = pRM_V_NOMBRE; }

    public String getPRM_V_DESCRIPCION() { return PRM_V_DESCRIPCION; }
    public void setPRM_V_DESCRIPCION(String pRM_V_DESCRIPCION) { PRM_V_DESCRIPCION = pRM_V_DESCRIPCION; }

    public String getPRM_V_ESTADO() { return PRM_V_ESTADO; }
    public void setPRM_V_ESTADO(String pRM_V_ESTADO) { PRM_V_ESTADO = pRM_V_ESTADO; }
}