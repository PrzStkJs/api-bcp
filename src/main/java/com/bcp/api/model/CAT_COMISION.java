package com.bcp.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "CAT_COMISION")
public class CAT_COMISION {

    @Id
    @Column(name = "COM_N_ID")
    @JsonProperty("COM_N_ID")
    private int COM_N_ID;

    @Column(name = "COM_V_NOMBRE")
    @JsonProperty("COM_V_NOMBRE")
    private String COM_V_NOMBRE;

    @Column(name = "COM_V_CONDICION")
    @JsonProperty("COM_V_CONDICION")
    private String COM_V_CONDICION;

    @Column(name = "COM_V_ESTADO")
    @JsonProperty("COM_V_ESTADO")
    private String COM_V_ESTADO;

    @Column(name = "COM_V_DESCRIPCION")
    @JsonProperty("COM_V_DESCRIPCION")
    private String COM_V_DESCRIPCION;

    // Relaciones (Llaves Foráneas)
    @ManyToOne
    @JoinColumn(name = "TPC_N_ID")
    @JsonProperty("tipoComision")
    private CAT_TIPO_COMISION tipoComision;

    @ManyToOne
    @JoinColumn(name = "TCB_N_ID")
    @JsonProperty("tipoCuenta")
    private CAT_TIPO_CUENTA_BANCARIA tipoCuenta;

    public CAT_COMISION() {}

    public CAT_COMISION(int COM_N_ID, String COM_V_NOMBRE, String COM_V_CONDICION, 
                        String COM_V_ESTADO, String COM_V_DESCRIPCION, 
                        CAT_TIPO_COMISION tipoComision, CAT_TIPO_CUENTA_BANCARIA tipoCuenta) {
        this.COM_N_ID = COM_N_ID;
        this.COM_V_NOMBRE = COM_V_NOMBRE;
        this.COM_V_CONDICION = COM_V_CONDICION;
        this.COM_V_ESTADO = COM_V_ESTADO;
        this.COM_V_DESCRIPCION = COM_V_DESCRIPCION;
        this.tipoComision = tipoComision;
        this.tipoCuenta = tipoCuenta;
    }

    public int getCOM_N_ID() { return COM_N_ID; }
    public void setCOM_N_ID(int cOM_N_ID) { COM_N_ID = cOM_N_ID; }

    public String getCOM_V_NOMBRE() { return COM_V_NOMBRE; }
    public void setCOM_V_NOMBRE(String cOM_V_NOMBRE) { COM_V_NOMBRE = cOM_V_NOMBRE; }

    public String getCOM_V_CONDICION() { return COM_V_CONDICION; }
    public void setCOM_V_CONDICION(String cOM_V_CONDICION) { COM_V_CONDICION = cOM_V_CONDICION; }

    public String getCOM_V_ESTADO() { return COM_V_ESTADO; }
    public void setCOM_V_ESTADO(String cOM_V_ESTADO) { COM_V_ESTADO = cOM_V_ESTADO; }

    public String getCOM_V_DESCRIPCION() { return COM_V_DESCRIPCION; }
    public void setCOM_V_DESCRIPCION(String cOM_V_DESCRIPCION) { COM_V_DESCRIPCION = cOM_V_DESCRIPCION; }

    public CAT_TIPO_COMISION getTipoComision() { return tipoComision; }
    public void setTipoComision(CAT_TIPO_COMISION tipoComision) { this.tipoComision = tipoComision; }

    public CAT_TIPO_CUENTA_BANCARIA getTipoCuenta() { return tipoCuenta; }
    public void setTipoCuenta(CAT_TIPO_CUENTA_BANCARIA tipoCuenta) { this.tipoCuenta = tipoCuenta; }
}