package com.bcp.api.model;

import java.io.Serializable;
import java.util.Objects;

public class USUARIO_ROL_ID implements Serializable {
    
    // Los nombres deben coincidir con los atributos de la clase USUARIO_ROL
    private int usuario; 
    private int rol;     

    public USUARIO_ROL_ID() {}

    public USUARIO_ROL_ID(int usuario, int rol) {
        this.usuario = usuario;
        this.rol = rol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        USUARIO_ROL_ID that = (USUARIO_ROL_ID) o;
        return usuario == that.usuario && rol == that.rol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuario, rol);
    }
}