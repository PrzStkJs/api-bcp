package com.bcp.api.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "CAT_VALOR_COMISION")
public class CAT_VALOR_COMISION {

    @Id
    @Column(name = "VLC_N_ID")
    @JsonProperty("VLC_N_ID")
    private int VLC_N_ID;

    @Column(name = "VLC_N_VALOR")
    @JsonProperty("VLC_N_VALOR")
    private double VLC_N_VALOR;

    @ManyToOne
    @JoinColumn(name = "COM_N_ID")
    @JsonProperty("comision")
    private CAT_COMISION comision;

    @ManyToOne
    @JoinColumn(name = "PRC_N_ID")
    @JsonProperty("parametroComision")
    private CAT_PARAMETRO_COMISION parametroComision;

    public CAT_VALOR_COMISION() {}

    public CAT_VALOR_COMISION(int VLC_N_ID, double VLC_N_VALOR, CAT_COMISION comision, 
                              CAT_PARAMETRO_COMISION parametroComision) {
        this.VLC_N_ID = VLC_N_ID;
        this.VLC_N_VALOR = VLC_N_VALOR;
        this.comision = comision;
        this.parametroComision = parametroComision;
    }

    public int getVLC_N_ID() { return VLC_N_ID; }
    public void setVLC_N_ID(int vLC_N_ID) { VLC_N_ID = vLC_N_ID; }

    public double getVLC_N_VALOR() { return VLC_N_VALOR; }
    public void setVLC_N_VALOR(double vLC_N_VALOR) { VLC_N_VALOR = vLC_N_VALOR; }

    public CAT_COMISION getComision() { return comision; }
    public void setComision(CAT_COMISION comision) { this.comision = comision; }

    public CAT_PARAMETRO_COMISION getParametroComision() { return parametroComision; }
    public void setParametroComision(CAT_PARAMETRO_COMISION parametroComision) { this.parametroComision = parametroComision; }
}