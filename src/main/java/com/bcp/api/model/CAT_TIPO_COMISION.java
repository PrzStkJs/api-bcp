package com.bcp.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "CAT_TIPO_COMISION")
public class CAT_TIPO_COMISION {

    @Id
    @Column(name = "TPC_N_ID")
    @JsonProperty("TPC_N_ID")
    private int TPC_N_ID;

    @Column(name = "TPC_V_NOMBRE")
    @JsonProperty("TPC_V_NOMBRE")
    private String TPC_V_NOMBRE;

    @Column(name = "TPC_V_DESCRIPCION")
    @JsonProperty("TPC_V_DESCRIPCION")
    private String TPC_V_DESCRIPCION;

    @Column(name = "TPC_V_ESTADO")
    @JsonProperty("TPC_V_ESTADO")
    private String TPC_V_ESTADO;

    public CAT_TIPO_COMISION() {}

    public CAT_TIPO_COMISION(int TPC_N_ID, String TPC_V_NOMBRE, String TPC_V_DESCRIPCION, String TPC_V_ESTADO) {
        this.TPC_N_ID = TPC_N_ID;
        this.TPC_V_NOMBRE = TPC_V_NOMBRE;
        this.TPC_V_DESCRIPCION = TPC_V_DESCRIPCION;
        this.TPC_V_ESTADO = TPC_V_ESTADO;
    }

    public int getTPC_N_ID() { return TPC_N_ID; }
    public void setTPC_N_ID(int tPC_N_ID) { TPC_N_ID = tPC_N_ID; }

    public String getTPC_V_NOMBRE() { return TPC_V_NOMBRE; }
    public void setTPC_V_NOMBRE(String tPC_V_NOMBRE) { TPC_V_NOMBRE = tPC_V_NOMBRE; }

    public String getTPC_V_DESCRIPCION() { return TPC_V_DESCRIPCION; }
    public void setTPC_V_DESCRIPCION(String tPC_V_DESCRIPCION) { TPC_V_DESCRIPCION = tPC_V_DESCRIPCION; }

    public String getTPC_V_ESTADO() { return TPC_V_ESTADO; }
    public void setTPC_V_ESTADO(String tPC_V_ESTADO) { TPC_V_ESTADO = tPC_V_ESTADO; }
}