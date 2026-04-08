package com.bcp.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "CAT_SERVICIO")
public class CAT_SERVICIO {

    @Id
    @Column(name = "SER_N_ID")
    @JsonProperty("SER_N_ID")
    private int SER_N_ID;

    @Column(name = "SER_V_NOMBRE")
    @JsonProperty("SER_V_NOMBRE")
    private String SER_V_NOMBRE;

    @Column(name = "SER_V_DESCRIPCION")
    @JsonProperty("SER_V_DESCRIPCION")
    private String SER_V_DESCRIPCION;

    @Column(name = "SER_V_ESTADO")
    @JsonProperty("SER_V_ESTADO")
    private String SER_V_ESTADO;

    public CAT_SERVICIO() {}

    public CAT_SERVICIO(int SER_N_ID, String SER_V_NOMBRE, String SER_V_DESCRIPCION, String SER_V_ESTADO) {
        this.SER_N_ID = SER_N_ID;
        this.SER_V_NOMBRE = SER_V_NOMBRE;
        this.SER_V_DESCRIPCION = SER_V_DESCRIPCION;
        this.SER_V_ESTADO = SER_V_ESTADO;
    }

    public int getSER_N_ID() { return SER_N_ID; }
    public void setSER_N_ID(int sER_N_ID) { SER_N_ID = sER_N_ID; }

    public String getSER_V_NOMBRE() { return SER_V_NOMBRE; }
    public void setSER_V_NOMBRE(String sER_V_NOMBRE) { SER_V_NOMBRE = sER_V_NOMBRE; }

    public String getSER_V_DESCRIPCION() { return SER_V_DESCRIPCION; }
    public void setSER_V_DESCRIPCION(String sER_V_DESCRIPCION) { SER_V_DESCRIPCION = sER_V_DESCRIPCION; }

    public String getSER_V_ESTADO() { return SER_V_ESTADO; }
    public void setSER_V_ESTADO(String sER_V_ESTADO) { SER_V_ESTADO = sER_V_ESTADO; }
}