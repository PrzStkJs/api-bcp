package com.bcp.api.model;

import java.io.Serializable;
import java.util.Objects;

public class TIPO_COMISION_PARAMETRO_ID implements Serializable {
    
    // Los nombres deben ser EXACTAMENTE iguales a los objetos de la clase principal
    private int tipoComision;           
    private int parametroComision; 

    public TIPO_COMISION_PARAMETRO_ID() {}

    public TIPO_COMISION_PARAMETRO_ID(int tipoComision, int parametroComision) {
        this.tipoComision = tipoComision;
        this.parametroComision = parametroComision;
    }

    // JPA exige equals y hashCode para comparar llaves compuestas
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TIPO_COMISION_PARAMETRO_ID that = (TIPO_COMISION_PARAMETRO_ID) o;
        return tipoComision == that.tipoComision && parametroComision == that.parametroComision;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipoComision, parametroComision);
    }
}