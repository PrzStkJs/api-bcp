package com.bcp.api.model;

import jakarta.persistence.*;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "SERVICIO_AGENCIA")
@IdClass(SERVICIO_AGENCIA_ID.class)
public class SERVICIO_AGENCIA implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "AGE_N_ID")
    @JsonProperty("agencia")
    private T_AGENCIA agencia;

    @Id
    @ManyToOne
    @JoinColumn(name = "SER_N_ID")
    @JsonProperty("servicio")
    private CAT_SERVICIO servicio;

    public SERVICIO_AGENCIA() {}

    public SERVICIO_AGENCIA(T_AGENCIA agencia, CAT_SERVICIO servicio) {
        this.agencia = agencia;
        this.servicio = servicio;
    }

    public T_AGENCIA getAgencia() { return agencia; }
    public void setAgencia(T_AGENCIA agencia) { this.agencia = agencia; }

    public CAT_SERVICIO getServicio() { return servicio; }
    public void setServicio(CAT_SERVICIO servicio) { this.servicio = servicio; }
}