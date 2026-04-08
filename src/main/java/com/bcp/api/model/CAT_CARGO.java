package com.bcp.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "CAT_CARGO")
public class CAT_CARGO {

    @Id
    @Column(name = "CAR_N_ID")
    @JsonProperty("CAR_N_ID")
    private int CAR_N_ID;

    @Column(name = "CAR_V_NOMBRE")
    @JsonProperty("CAR_V_NOMBRE")
    private String CAR_V_NOMBRE;

    @Column(name = "CAR_V_DESCRIPCION")
    @JsonProperty("CAR_V_DESCRIPCION")
    private String CAR_V_DESCRIPCION;

    @Column(name = "CAR_V_ESTADO")
    @JsonProperty("CAR_V_ESTADO")
    private String CAR_V_ESTADO;

    public CAT_CARGO() {}

    public CAT_CARGO(int CAR_N_ID, String CAR_V_NOMBRE, String CAR_V_DESCRIPCION, String CAR_V_ESTADO) {
        this.CAR_N_ID = CAR_N_ID;
        this.CAR_V_NOMBRE = CAR_V_NOMBRE;
        this.CAR_V_DESCRIPCION = CAR_V_DESCRIPCION;
        this.CAR_V_ESTADO = CAR_V_ESTADO;
    }

    public int getCAR_N_ID() { return CAR_N_ID; }
    public void setCAR_N_ID(int cAR_N_ID) { CAR_N_ID = cAR_N_ID; }

    public String getCAR_V_NOMBRE() { return CAR_V_NOMBRE; }
    public void setCAR_V_NOMBRE(String cAR_V_NOMBRE) { CAR_V_NOMBRE = cAR_V_NOMBRE; }

    public String getCAR_V_DESCRIPCION() { return CAR_V_DESCRIPCION; }
    public void setCAR_V_DESCRIPCION(String cAR_V_DESCRIPCION) { CAR_V_DESCRIPCION = cAR_V_DESCRIPCION; }

    public String getCAR_V_ESTADO() { return CAR_V_ESTADO; }
    public void setCAR_V_ESTADO(String cAR_V_ESTADO) { CAR_V_ESTADO = cAR_V_ESTADO; }
}