package com.bcp.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "CAT_TIPO_PRESTAMO")
public class CAT_TIPO_PRESTAMO {

    @Id
    @Column(name = "TPR_N_ID")
    @JsonProperty("TPR_N_ID")
    private int TPR_N_ID;

    @Column(name = "TPR_V_NOMBRE")
    @JsonProperty("TPR_V_NOMBRE")
    private String TPR_V_NOMBRE;

    @Column(name = "TPR_V_DESCRIPCION")
    @JsonProperty("TPR_V_DESCRIPCION")
    private String TPR_V_DESCRIPCION;

    @Column(name = "TPR_V_ESTADO")
    @JsonProperty("TPR_V_ESTADO")
    private String TPR_V_ESTADO;

    public CAT_TIPO_PRESTAMO() {}

    public CAT_TIPO_PRESTAMO(int TPR_N_ID, String TPR_V_NOMBRE, String TPR_V_DESCRIPCION, String TPR_V_ESTADO) {
        this.TPR_N_ID = TPR_N_ID;
        this.TPR_V_NOMBRE = TPR_V_NOMBRE;
        this.TPR_V_DESCRIPCION = TPR_V_DESCRIPCION;
        this.TPR_V_ESTADO = TPR_V_ESTADO;
    }

    public int getTPR_N_ID() { return TPR_N_ID; }
    public void setTPR_N_ID(int tPR_N_ID) { TPR_N_ID = tPR_N_ID; }

    public String getTPR_V_NOMBRE() { return TPR_V_NOMBRE; }
    public void setTPR_V_NOMBRE(String tPR_V_NOMBRE) { TPR_V_NOMBRE = tPR_V_NOMBRE; }

    public String getTPR_V_DESCRIPCION() { return TPR_V_DESCRIPCION; }
    public void setTPR_V_DESCRIPCION(String tPR_V_DESCRIPCION) { TPR_V_DESCRIPCION = tPR_V_DESCRIPCION; }

    public String getTPR_V_ESTADO() { return TPR_V_ESTADO; }
    public void setTPR_V_ESTADO(String tPR_V_ESTADO) { TPR_V_ESTADO = tPR_V_ESTADO; }
}