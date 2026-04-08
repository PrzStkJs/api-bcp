package com.bcp.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "CAT_ACCION_AUDITORIA")
public class CAT_ACCION_AUDITORIA {

    @Id
    @Column(name = "ACU_N_ID")
    @JsonProperty("ACU_N_ID")
    private int ACU_N_ID;

    @Column(name = "ACU_V_NOMBRE")
    @JsonProperty("ACU_V_NOMBRE")
    private String ACU_V_NOMBRE;

    @Column(name = "ACU_V_DESCRIPCION")
    @JsonProperty("ACU_V_DESCRIPCION")
    private String ACU_V_DESCRIPCION;

    @Column(name = "ACU_V_ESTADO")
    @JsonProperty("ACU_V_ESTADO")
    private String ACU_V_ESTADO;

    // Constructor vacío
    public CAT_ACCION_AUDITORIA() {}

    // Constructor con parámetros
    public CAT_ACCION_AUDITORIA(int ACU_N_ID, String ACU_V_NOMBRE, String ACU_V_DESCRIPCION, String ACU_V_ESTADO) {
        this.ACU_N_ID = ACU_N_ID;
        this.ACU_V_NOMBRE = ACU_V_NOMBRE;
        this.ACU_V_DESCRIPCION = ACU_V_DESCRIPCION;
        this.ACU_V_ESTADO = ACU_V_ESTADO;
    }

    // Getters y Setters
    public int getACU_N_ID() { return ACU_N_ID; }
    public void setACU_N_ID(int aCU_N_ID) { ACU_N_ID = aCU_N_ID; }

    public String getACU_V_NOMBRE() { return ACU_V_NOMBRE; }
    public void setACU_V_NOMBRE(String aCU_V_NOMBRE) { ACU_V_NOMBRE = aCU_V_NOMBRE; }

    public String getACU_V_DESCRIPCION() { return ACU_V_DESCRIPCION; }
    public void setACU_V_DESCRIPCION(String aCU_V_DESCRIPCION) { ACU_V_DESCRIPCION = aCU_V_DESCRIPCION; }

    public String getACU_V_ESTADO() { return ACU_V_ESTADO; }
    public void setACU_V_ESTADO(String aCU_V_ESTADO) { ACU_V_ESTADO = aCU_V_ESTADO; }
}