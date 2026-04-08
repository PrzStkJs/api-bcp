package com.bcp.api.model;

import jakarta.persistence.*;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "T_LOG")
public class T_LOG {

    @Id
    @Column(name = "LOG_N_ID")
    @JsonProperty("LOG_N_ID")
    private int LOG_N_ID;

    @Column(name = "LOG_D_FECHA_HORA")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonProperty("LOG_D_FECHA_HORA")
    private Date LOG_D_FECHA_HORA;

    @Column(name = "LOG_V_IP")
    @JsonProperty("LOG_V_IP")
    private String LOG_V_IP;

    @Column(name = "LOG_V_REGISTRO")
    @JsonProperty("LOG_V_REGISTRO")
    private String LOG_V_REGISTRO;

    @Column(name = "LOG_N_INTENTOS_FALLIDOS")
    @JsonProperty("LOG_N_INTENTOS_FALLIDOS")
    private int LOG_N_INTENTOS_FALLIDOS;
    
    @ManyToOne
    @JoinColumn(name = "USR_N_ID")
    @JsonProperty("usuario")
    private T_USUARIO usuario;

    public T_LOG() {}

    public T_LOG(int LOG_N_ID, Date LOG_D_FECHA_HORA, String LOG_V_IP, String LOG_V_REGISTRO, 
                 int LOG_N_INTENTOS_FALLIDOS, T_USUARIO usuario) {
        this.LOG_N_ID = LOG_N_ID;
        this.LOG_D_FECHA_HORA = LOG_D_FECHA_HORA;
        this.LOG_V_IP = LOG_V_IP;
        this.LOG_V_REGISTRO = LOG_V_REGISTRO;
        this.LOG_N_INTENTOS_FALLIDOS = LOG_N_INTENTOS_FALLIDOS;
        this.usuario = usuario;
    }

    public int getLOG_N_ID() { return LOG_N_ID; }
    public void setLOG_N_ID(int lOG_N_ID) { LOG_N_ID = lOG_N_ID; }

    public Date getLOG_D_FECHA_HORA() { return LOG_D_FECHA_HORA; }
    public void setLOG_D_FECHA_HORA(Date lOG_D_FECHA_HORA) { LOG_D_FECHA_HORA = lOG_D_FECHA_HORA; }

    public String getLOG_V_IP() { return LOG_V_IP; }
    public void setLOG_V_IP(String lOG_V_IP) { LOG_V_IP = lOG_V_IP; }

    public String getLOG_V_REGISTRO() { return LOG_V_REGISTRO; }
    public void setLOG_V_REGISTRO(String lOG_V_REGISTRO) { LOG_V_REGISTRO = lOG_V_REGISTRO; }

    public int getLOG_N_INTENTOS_FALLIDOS() { return LOG_N_INTENTOS_FALLIDOS; }
    public void setLOG_N_INTENTOS_FALLIDOS(int lOG_N_INTENTOS_FALLIDOS) { LOG_N_INTENTOS_FALLIDOS = lOG_N_INTENTOS_FALLIDOS; }

    public T_USUARIO getUsuario() { return usuario; }
    public void setUsuario(T_USUARIO usuario) { this.usuario = usuario; }
}