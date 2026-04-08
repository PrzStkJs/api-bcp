package com.bcp.api.model;

import java.io.Serializable;
import java.util.Objects;

public class TCB_MONEDA_ID implements Serializable {
    
    // Los nombres deben ser EXACTAMENTE iguales a los objetos de la clase TCB_MONEDA
    private int tipoCuentaBancaria; 
    private int moneda;             

    public TCB_MONEDA_ID() {}

    public TCB_MONEDA_ID(int tipoCuentaBancaria, int moneda) {
        this.tipoCuentaBancaria = tipoCuentaBancaria;
        this.moneda = moneda;
    }

    // JPA exige equals y hashCode para comparar llaves compuestas
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TCB_MONEDA_ID that = (TCB_MONEDA_ID) o;
        return tipoCuentaBancaria == that.tipoCuentaBancaria && moneda == that.moneda;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipoCuentaBancaria, moneda);
    }
}