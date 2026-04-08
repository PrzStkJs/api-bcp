package com.bcp.api.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "TIPO_COMISION_PARAMETRO")
@IdClass(TIPO_COMISION_PARAMETRO_ID.class)
public class TIPO_COMISION_PARAMETRO {

    @Id
    @ManyToOne
    @JoinColumn(name = "TPC_N_ID")
    @JsonProperty("tipoComision")
    private CAT_TIPO_COMISION tipoComision;

    @Id
    @ManyToOne
    @JoinColumn(name = "PRC_N_ID")
    @JsonProperty("parametroComision")
    private CAT_PARAMETRO_COMISION parametroComision;

    public TIPO_COMISION_PARAMETRO() {}

    public TIPO_COMISION_PARAMETRO(CAT_TIPO_COMISION tipoComision, CAT_PARAMETRO_COMISION parametroComision) {
        this.tipoComision = tipoComision;
        this.parametroComision = parametroComision;
    }

    public CAT_TIPO_COMISION getTipoComision() { return tipoComision; }
    public void setTipoComision(CAT_TIPO_COMISION tipoComision) { this.tipoComision = tipoComision; }

    public CAT_PARAMETRO_COMISION getParametroComision() { return parametroComision; }
    public void setParametroComision(CAT_PARAMETRO_COMISION parametroComision) { this.parametroComision = parametroComision; }
}