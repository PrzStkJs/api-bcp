package com.bcp.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "CAT_TIPO_CUENTA_BANCARIA")
public class CAT_TIPO_CUENTA_BANCARIA {

    @Id
    @Column(name = "TCB_N_ID")
    @JsonProperty("TCB_N_ID")
    private int TCB_N_ID;

    @Column(name = "TCB_V_NOMBRE")
    @JsonProperty("TCB_V_NOMBRE")
    private String TCB_V_NOMBRE;

    @Column(name = "TCB_V_DESCRIPCION")
    @JsonProperty("TCB_V_DESCRIPCION")
    private String TCB_V_DESCRIPCION;

    @Column(name = "TCB_N_LIMITE_OPERACIONES")
    @JsonProperty("TCB_N_LIMITE_OPERACIONES")
    private int TCB_N_LIMITE_OPERACIONES;

    @Column(name = "TCB_V_ESTADO")
    @JsonProperty("TCB_V_ESTADO")
    private String TCB_V_ESTADO;

    @Column(name = "TCB_V_REQUISITOS_APERTURA")
    @JsonProperty("TCB_V_REQUISITOS_APERTURA")
    private String TCB_V_REQUISITOS_APERTURA;

    public CAT_TIPO_CUENTA_BANCARIA() {}

    public CAT_TIPO_CUENTA_BANCARIA(int TCB_N_ID, String TCB_V_NOMBRE, String TCB_V_DESCRIPCION, int TCB_N_LIMITE_OPERACIONES, String TCB_V_ESTADO, String TCB_V_REQUISITOS_APERTURA) {
        this.TCB_N_ID = TCB_N_ID;
        this.TCB_V_NOMBRE = TCB_V_NOMBRE;
        this.TCB_V_DESCRIPCION = TCB_V_DESCRIPCION;
        this.TCB_N_LIMITE_OPERACIONES = TCB_N_LIMITE_OPERACIONES;
        this.TCB_V_ESTADO = TCB_V_ESTADO;
        this.TCB_V_REQUISITOS_APERTURA = TCB_V_REQUISITOS_APERTURA;
    }

    // Getters y Setters
    public int getTCB_N_ID() { return TCB_N_ID; }
    public void setTCB_N_ID(int tCB_N_ID) { TCB_N_ID = tCB_N_ID; }

    public String getTCB_V_NOMBRE() { return TCB_V_NOMBRE; }
    public void setTCB_V_NOMBRE(String tCB_V_NOMBRE) { TCB_V_NOMBRE = tCB_V_NOMBRE; }

    public String getTCB_V_DESCRIPCION() { return TCB_V_DESCRIPCION; }
    public void setTCB_V_DESCRIPCION(String tCB_V_DESCRIPCION) { TCB_V_DESCRIPCION = tCB_V_DESCRIPCION; }

    public int getTCB_N_LIMITE_OPERACIONES() { return TCB_N_LIMITE_OPERACIONES; }
    public void setTCB_N_LIMITE_OPERACIONES(int tCB_N_LIMITE_OPERACIONES) { TCB_N_LIMITE_OPERACIONES = tCB_N_LIMITE_OPERACIONES; }

    public String getTCB_V_ESTADO() { return TCB_V_ESTADO; }
    public void setTCB_V_ESTADO(String tCB_V_ESTADO) { TCB_V_ESTADO = tCB_V_ESTADO; }

    public String getTCB_V_REQUISITOS_APERTURA() { return TCB_V_REQUISITOS_APERTURA; }
    public void setTCB_V_REQUISITOS_APERTURA(String tCB_V_REQUISITOS_APERTURA) { TCB_V_REQUISITOS_APERTURA = tCB_V_REQUISITOS_APERTURA; }
}