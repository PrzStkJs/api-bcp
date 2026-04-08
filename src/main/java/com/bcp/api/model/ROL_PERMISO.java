package com.bcp.api.model;

import jakarta.persistence.*;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "ROL_PERMISO")
@IdClass(ROL_PERMISO_ID.class)
public class ROL_PERMISO implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "ROL_N_ID")
    @JsonProperty("rol")
    private CAT_ROL rol;

    @Id
    @ManyToOne
    @JoinColumn(name = "PRM_N_ID")
    @JsonProperty("permiso")
    private CAT_PERMISO permiso;

    public ROL_PERMISO() {}

    public ROL_PERMISO(CAT_ROL rol, CAT_PERMISO permiso) {
        this.rol = rol;
        this.permiso = permiso;
    }

    public CAT_ROL getRol() { return rol; }
    public void setRol(CAT_ROL rol) { this.rol = rol; }

    public CAT_PERMISO getPermiso() { return permiso; }
    public void setPermiso(CAT_PERMISO permiso) { this.permiso = permiso; }
}