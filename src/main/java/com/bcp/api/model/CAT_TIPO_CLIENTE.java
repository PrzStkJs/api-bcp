package com.bcp.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "CAT_TIPO_CLIENTE")
public class CAT_TIPO_CLIENTE {

    @Id
    @Column(name = "TCL_N_ID")
    @JsonProperty("TCL_N_ID")
    private int TCL_N_ID;

    @Column(name = "TCL_V_NOMBRE")
    @JsonProperty("TCL_V_NOMBRE")
    private String TCL_V_NOMBRE;

    @Column(name = "TCL_V_DESCRIPCION")
    @JsonProperty("TCL_V_DESCRIPCION")
    private String TCL_V_DESCRIPCION;

    @Column(name = "TCL_V_ESTADO")
    @JsonProperty("TCL_V_ESTADO")
    private String TCL_V_ESTADO;

    public CAT_TIPO_CLIENTE() {}

    public CAT_TIPO_CLIENTE(int TCL_N_ID, String TCL_V_NOMBRE, String TCL_V_DESCRIPCION, String TCL_V_ESTADO) {
        this.TCL_N_ID = TCL_N_ID;
        this.TCL_V_NOMBRE = TCL_V_NOMBRE;
        this.TCL_V_DESCRIPCION = TCL_V_DESCRIPCION;
        this.TCL_V_ESTADO = TCL_V_ESTADO;
    }

    public int getTCL_N_ID() { return TCL_N_ID; }
    public void setTCL_N_ID(int tCL_N_ID) { TCL_N_ID = tCL_N_ID; }

    public String getTCL_V_NOMBRE() { return TCL_V_NOMBRE; }
    public void setTCL_V_NOMBRE(String tCL_V_NOMBRE) { TCL_V_NOMBRE = tCL_V_NOMBRE; }

    public String getTCL_V_DESCRIPCION() { return TCL_V_DESCRIPCION; }
    public void setTCL_V_DESCRIPCION(String tCL_V_DESCRIPCION) { TCL_V_DESCRIPCION = tCL_V_DESCRIPCION; }

    public String getTCL_V_ESTADO() { return TCL_V_ESTADO; }
    public void setTCL_V_ESTADO(String tCL_V_ESTADO) { TCL_V_ESTADO = tCL_V_ESTADO; }
}