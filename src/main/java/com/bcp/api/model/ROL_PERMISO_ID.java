package com.bcp.api.model;

import java.io.Serializable;
import java.util.Objects;

public class ROL_PERMISO_ID implements Serializable {
    private int rol;     
    private int permiso; 

    public ROL_PERMISO_ID() {}

    public ROL_PERMISO_ID(int rol, int permiso) {
        this.rol = rol;
        this.permiso = permiso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ROL_PERMISO_ID that = (ROL_PERMISO_ID) o;
        return rol == that.rol && permiso == that.permiso;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rol, permiso);
    }
}