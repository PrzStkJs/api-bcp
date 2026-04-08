package com.bcp.api.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "T_USUARIO")
public class T_USUARIO {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usr_gen")
    @SequenceGenerator(
        name = "usr_gen", 
        sequenceName = "T_USUARIO_USR_N_ID_SEQ", // Nombre exacto de tu SQL
        allocationSize = 1
    )
    @Column(name = "USR_N_ID")
    @JsonProperty("USR_N_ID")
    private Integer USR_N_ID; // Cambiado de int a Integer

    @Column(name = "USR_V_CORREO")
    @JsonProperty("USR_V_CORREO")
    private String USR_V_CORREO;

    @Column(name = "USR_V_PASSWORD")
    @JsonProperty("USR_V_PASSWORD")
    private String USR_V_PASSWORD;

    @Column(name = "USR_V_ESTADO")
    @JsonProperty("USR_V_ESTADO")
    private String USR_V_ESTADO;
    
    @ManyToOne
    @JoinColumn(name = "PER_N_ID")
    @JsonProperty("persona")
    private T_PERSONA persona; 

    public T_USUARIO() {}

    public T_USUARIO(int USR_N_ID, String USR_V_CORREO, String USR_V_PASSWORD, String USR_V_ESTADO, T_PERSONA persona) {
        this.USR_N_ID = USR_N_ID;
        this.USR_V_CORREO = USR_V_CORREO;
        this.USR_V_PASSWORD = USR_V_PASSWORD;
        this.USR_V_ESTADO = USR_V_ESTADO;
        this.persona = persona;
    }

    public int getUSR_N_ID() { return USR_N_ID; }
    public void setUSR_N_ID(int uSR_N_ID) { USR_N_ID = uSR_N_ID; }

    public String getUSR_V_CORREO() { return USR_V_CORREO; }
    public void setUSR_V_CORREO(String uSR_V_CORREO) { USR_V_CORREO = uSR_V_CORREO; }

    public String getUSR_V_PASSWORD() { return USR_V_PASSWORD; }
    public void setUSR_V_PASSWORD(String uSR_V_PASSWORD) { USR_V_PASSWORD = uSR_V_PASSWORD; }

    public String getUSR_V_ESTADO() { return USR_V_ESTADO; }
    public void setUSR_V_ESTADO(String uSR_V_ESTADO) { USR_V_ESTADO = uSR_V_ESTADO; }

    public T_PERSONA getPersona() { return persona; }
    public void setPersona(T_PERSONA persona) { this.persona = persona; }
}