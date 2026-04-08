package com.bcp.api.model;

import java.io.Serializable;
import java.util.Objects;

public class SERVICIO_AGENCIA_ID implements Serializable {
    private int agencia;  // Coincide con el nombre del atributo en la entidad
    private int servicio; // Coincide con el nombre del atributo en la entidad

    public SERVICIO_AGENCIA_ID() {}

    public SERVICIO_AGENCIA_ID(int agencia, int servicio) {
        this.agencia = agencia;
        this.servicio = servicio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SERVICIO_AGENCIA_ID that = (SERVICIO_AGENCIA_ID) o;
        return agencia == that.agencia && servicio == that.servicio;
    }

    @Override
    public int hashCode() {
        return Objects.hash(agencia, servicio);
    }
}