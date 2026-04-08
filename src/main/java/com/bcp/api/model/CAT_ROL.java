package com.bcp.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "CAT_ROL")
public class CAT_ROL {

    @Id
    @Column(name = "ROL_N_ID")
    @JsonProperty("ROL_N_ID")
    private int ROL_N_ID;

    @Column(name = "ROL_V_NOMBRE")
    @JsonProperty("ROL_V_NOMBRE")
    private String ROL_V_NOMBRE;

    @Column(name = "ROL_V_DESCRIPCION")
    @JsonProperty("ROL_V_DESCRIPCION")
    private String ROL_V_DESCRIPCION;

    @Column(name = "ROL_V_ESTADO")
    @JsonProperty("ROL_V_ESTADO")
    private String ROL_V_ESTADO;

    public CAT_ROL() {}

    public CAT_ROL(int ROL_N_ID, String ROL_V_NOMBRE, String ROL_V_DESCRIPCION, String ROL_V_ESTADO) {
        this.ROL_N_ID = ROL_N_ID;
        this.ROL_V_NOMBRE = ROL_V_NOMBRE;
        this.ROL_V_DESCRIPCION = ROL_V_DESCRIPCION;
        this.ROL_V_ESTADO = ROL_V_ESTADO;
    }

    public int getROL_N_ID() { return ROL_N_ID; }
    public void setROL_N_ID(int rOL_N_ID) { ROL_N_ID = rOL_N_ID; }

    public String getROL_V_NOMBRE() { return ROL_V_NOMBRE; }
    public void setROL_V_NOMBRE(String rOL_V_NOMBRE) { ROL_V_NOMBRE = rOL_V_NOMBRE; }

    public String getROL_V_DESCRIPCION() { return ROL_V_DESCRIPCION; }
    public void setROL_V_DESCRIPCION(String rOL_V_DESCRIPCION) { ROL_V_DESCRIPCION = rOL_V_DESCRIPCION; }

    public String getROL_V_ESTADO() { return ROL_V_ESTADO; }
    public void setROL_V_ESTADO(String rOL_V_ESTADO) { ROL_V_ESTADO = rOL_V_ESTADO; }
}