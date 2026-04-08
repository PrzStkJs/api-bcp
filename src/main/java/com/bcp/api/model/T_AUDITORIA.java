package com.bcp.api.model;

import jakarta.persistence.*;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "T_AUDITORIA")
public class T_AUDITORIA {

    @Id
    @Column(name = "AUD_N_ID")
    @JsonProperty("AUD_N_ID")
    private int AUD_N_ID;

    @Column(name = "AUD_V_TABLA")
    @JsonProperty("AUD_V_TABLA")
    private String AUD_V_TABLA;

    @Column(name = "AUD_N_REGISTRO")
    @JsonProperty("AUD_N_REGISTRO")
    private int AUD_N_REGISTRO;

    @Column(name = "AUD_D_FECHA_HORA")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonProperty("AUD_D_FECHA_HORA")
    private Date AUD_D_FECHA_HORA;
    
    @ManyToOne
    @JoinColumn(name = "ACU_N_ID")
    @JsonProperty("accionAuditoria")
    private CAT_ACCION_AUDITORIA accionAuditoria;

    @ManyToOne
    @JoinColumn(name = "USR_N_ID")
    @JsonProperty("usuario")
    private T_USUARIO usuario;

    public T_AUDITORIA() {}

    public T_AUDITORIA(int AUD_N_ID, String AUD_V_TABLA, int AUD_N_REGISTRO, Date AUD_D_FECHA_HORA, 
                       CAT_ACCION_AUDITORIA accionAuditoria, T_USUARIO usuario) {
        this.AUD_N_ID = AUD_N_ID;
        this.AUD_V_TABLA = AUD_V_TABLA;
        this.AUD_N_REGISTRO = AUD_N_REGISTRO;
        this.AUD_D_FECHA_HORA = AUD_D_FECHA_HORA;
        this.accionAuditoria = accionAuditoria;
        this.usuario = usuario;
    }

    public int getAUD_N_ID() { return AUD_N_ID; }
    public void setAUD_N_ID(int aUD_N_ID) { AUD_N_ID = aUD_N_ID; }

    public String getAUD_V_TABLA() { return AUD_V_TABLA; }
    public void setAUD_V_TABLA(String aUD_V_TABLA) { AUD_V_TABLA = aUD_V_TABLA; }

    public int getAUD_N_REGISTRO() { return AUD_N_REGISTRO; }
    public void setAUD_N_REGISTRO(int aUD_N_REGISTRO) { AUD_N_REGISTRO = aUD_N_REGISTRO; }

    public Date getAUD_D_FECHA_HORA() { return AUD_D_FECHA_HORA; }
    public void setAUD_D_FECHA_HORA(Date aUD_D_FECHA_HORA) { AUD_D_FECHA_HORA = aUD_D_FECHA_HORA; }

    public CAT_ACCION_AUDITORIA getAccionAuditoria() { return accionAuditoria; }
    public void setAccionAuditoria(CAT_ACCION_AUDITORIA accionAuditoria) { this.accionAuditoria = accionAuditoria; }

    public T_USUARIO getUsuario() { return usuario; }
    public void setUsuario(T_USUARIO usuario) { this.usuario = usuario; }
}