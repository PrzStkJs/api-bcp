package com.bcp.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "CAT_MARCA_TARJETA")
public class CAT_MARCA_TARJETA {

    @Id
    @Column(name = "MAR_N_ID")
    @JsonProperty("MAR_N_ID")
    private int MAR_N_ID;

    @Column(name = "MAR_V_NOMBRE")
    @JsonProperty("MAR_V_NOMBRE")
    private String MAR_V_NOMBRE;

    @Column(name = "MAR_V_DESCRIPCION")
    @JsonProperty("MAR_V_DESCRIPCION")
    private String MAR_V_DESCRIPCION;

    @Column(name = "MAR_V_ESTADO")
    @JsonProperty("MAR_V_ESTADO")
    private String MAR_V_ESTADO;

    public CAT_MARCA_TARJETA() {}

    public CAT_MARCA_TARJETA(int MAR_N_ID, String MAR_V_NOMBRE, String MAR_V_DESCRIPCION, String MAR_V_ESTADO) {
        this.MAR_N_ID = MAR_N_ID;
        this.MAR_V_NOMBRE = MAR_V_NOMBRE;
        this.MAR_V_DESCRIPCION = MAR_V_DESCRIPCION;
        this.MAR_V_ESTADO = MAR_V_ESTADO;
    }

    public int getMAR_N_ID() { return MAR_N_ID; }
    public void setMAR_N_ID(int mAR_N_ID) { MAR_N_ID = mAR_N_ID; }

    public String getMAR_V_NOMBRE() { return MAR_V_NOMBRE; }
    public void setMAR_V_NOMBRE(String mAR_V_NOMBRE) { MAR_V_NOMBRE = mAR_V_NOMBRE; }

    public String getMAR_V_DESCRIPCION() { return MAR_V_DESCRIPCION; }
    public void setMAR_V_DESCRIPCION(String mAR_V_DESCRIPCION) { MAR_V_DESCRIPCION = mAR_V_DESCRIPCION; }

    public String getMAR_V_ESTADO() { return MAR_V_ESTADO; }
    public void setMAR_V_ESTADO(String mAR_V_ESTADO) { MAR_V_ESTADO = mAR_V_ESTADO; }
}