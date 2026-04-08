package com.bcp.api.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "USUARIO_ROL")
@IdClass(USUARIO_ROL_ID.class)
public class USUARIO_ROL {

    @Id
    @ManyToOne
    @JoinColumn(name = "USR_N_ID")
    @JsonProperty("usuario")
    private T_USUARIO usuario;

    @Id
    @ManyToOne
    @JoinColumn(name = "ROL_N_ID")
    @JsonProperty("rol")
    private CAT_ROL rol;

    public USUARIO_ROL() {}

    public USUARIO_ROL(T_USUARIO usuario, CAT_ROL rol) {
        this.usuario = usuario;
        this.rol = rol;
    }

    public T_USUARIO getUsuario() { return usuario; }
    public void setUsuario(T_USUARIO usuario) { this.usuario = usuario; }

    public CAT_ROL getRol() { return rol; }
    public void setRol(CAT_ROL rol) { this.rol = rol; }
}