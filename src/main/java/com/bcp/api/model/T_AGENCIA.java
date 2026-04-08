package com.bcp.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "T_AGENCIA")
public class T_AGENCIA {

    @Id
    @Column(name = "AGE_N_ID")
    @JsonProperty("AGE_N_ID")
    private int AGE_N_ID;

    @Column(name = "AGE_V_NOMBRE")
    @JsonProperty("AGE_V_NOMBRE")
    private String AGE_V_NOMBRE;

    @Column(name = "AGE_V_CODIGO")
    @JsonProperty("AGE_V_CODIGO")
    private String AGE_V_CODIGO;

    @Column(name = "AGE_V_DIRECCION")
    @JsonProperty("AGE_V_DIRECCION")
    private String AGE_V_DIRECCION;

    @Column(name = "AGE_V_CIUDAD")
    @JsonProperty("AGE_V_CIUDAD")
    private String AGE_V_CIUDAD;

    @Column(name = "AGE_V_HORARIO")
    @JsonProperty("AGE_V_HORARIO")
    private String AGE_V_HORARIO;

    @Column(name = "AGE_V_ESTADO")
    @JsonProperty("AGE_V_ESTADO")
    private String AGE_V_ESTADO;

    @Column(name = "AGE_N_CAPACIDAD")
    @JsonProperty("AGE_N_CAPACIDAD")
    private int AGE_N_CAPACIDAD;

    public T_AGENCIA() {}

    public T_AGENCIA(int AGE_N_ID, String AGE_V_NOMBRE, String AGE_V_CODIGO, String AGE_V_DIRECCION, 
                     String AGE_V_CIUDAD, String AGE_V_HORARIO, String AGE_V_ESTADO, int AGE_N_CAPACIDAD) {
        this.AGE_N_ID = AGE_N_ID;
        this.AGE_V_NOMBRE = AGE_V_NOMBRE;
        this.AGE_V_CODIGO = AGE_V_CODIGO;
        this.AGE_V_DIRECCION = AGE_V_DIRECCION;
        this.AGE_V_CIUDAD = AGE_V_CIUDAD;
        this.AGE_V_HORARIO = AGE_V_HORARIO;
        this.AGE_V_ESTADO = AGE_V_ESTADO;
        this.AGE_N_CAPACIDAD = AGE_N_CAPACIDAD;
    }

    public int getAGE_N_ID() { return AGE_N_ID; }
    public void setAGE_N_ID(int aGE_N_ID) { AGE_N_ID = aGE_N_ID; }

    public String getAGE_V_NOMBRE() { return AGE_V_NOMBRE; }
    public void setAGE_V_NOMBRE(String aGE_V_NOMBRE) { AGE_V_NOMBRE = aGE_V_NOMBRE; }

    public String getAGE_V_CODIGO() { return AGE_V_CODIGO; }
    public void setAGE_V_CODIGO(String aGE_V_CODIGO) { AGE_V_CODIGO = aGE_V_CODIGO; }

    public String getAGE_V_DIRECCION() { return AGE_V_DIRECCION; }
    public void setAGE_V_DIRECCION(String aGE_V_DIRECCION) { AGE_V_DIRECCION = aGE_V_DIRECCION; }

    public String getAGE_V_CIUDAD() { return AGE_V_CIUDAD; }
    public void setAGE_V_CIUDAD(String aGE_V_CIUDAD) { AGE_V_CIUDAD = aGE_V_CIUDAD; }

    public String getAGE_V_HORARIO() { return AGE_V_HORARIO; }
    public void setAGE_V_HORARIO(String aGE_V_HORARIO) { AGE_V_HORARIO = aGE_V_HORARIO; }

    public String getAGE_V_ESTADO() { return AGE_V_ESTADO; }
    public void setAGE_V_ESTADO(String aGE_V_ESTADO) { AGE_V_ESTADO = aGE_V_ESTADO; }

    public int getAGE_N_CAPACIDAD() { return AGE_N_CAPACIDAD; }
    public void setAGE_N_CAPACIDAD(int aGE_N_CAPACIDAD) { AGE_N_CAPACIDAD = aGE_N_CAPACIDAD; }
}