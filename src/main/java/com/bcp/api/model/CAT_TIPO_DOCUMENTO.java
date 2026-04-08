package com.bcp.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "CAT_TIPO_DOCUMENTO")
public class CAT_TIPO_DOCUMENTO {

    @Id
    @Column(name = "TDC_N_ID")
    @JsonProperty("TDC_N_ID")
    private int TDC_N_ID;

    @Column(name = "TDC_V_NOMBRE")
    @JsonProperty("TDC_V_NOMBRE")
    private String TDC_V_NOMBRE;

    @Column(name = "TDC_V_DESCRIPCION")
    @JsonProperty("TDC_V_DESCRIPCION")
    private String TDC_V_DESCRIPCION;

    @Column(name = "TDC_V_ESTADO")
    @JsonProperty("TDC_V_ESTADO")
    private String TDC_V_ESTADO;
    
    public CAT_TIPO_DOCUMENTO() {}

    public CAT_TIPO_DOCUMENTO(int TDC_N_ID, String TDC_V_NOMBRE, String TDC_V_DESCRIPCION, String TDC_V_ESTADO) {
        this.TDC_N_ID = TDC_N_ID;
        this.TDC_V_NOMBRE = TDC_V_NOMBRE;
        this.TDC_V_DESCRIPCION = TDC_V_DESCRIPCION;
        this.TDC_V_ESTADO = TDC_V_ESTADO;
    }
    
    public int getTDC_N_ID() { return TDC_N_ID; }
    public void setTDC_N_ID(int tDC_N_ID) { TDC_N_ID = tDC_N_ID; }

    public String getTDC_V_NOMBRE() { return TDC_V_NOMBRE; }
    public void setTDC_V_NOMBRE(String tDC_V_NOMBRE) { TDC_V_NOMBRE = tDC_V_NOMBRE; }

    public String getTDC_V_DESCRIPCION() { return TDC_V_DESCRIPCION; }
    public void setTDC_V_DESCRIPCION(String tDC_V_DESCRIPCION) { TDC_V_DESCRIPCION = tDC_V_DESCRIPCION; }

    public String getTDC_V_ESTADO() { return TDC_V_ESTADO; }
    public void setTDC_V_ESTADO(String tDC_V_ESTADO) { TDC_V_ESTADO = tDC_V_ESTADO; }
}