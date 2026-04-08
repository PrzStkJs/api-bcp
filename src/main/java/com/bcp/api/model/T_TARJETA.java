package com.bcp.api.model;

import jakarta.persistence.*;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "T_TARJETA")
public class T_TARJETA {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_tarjeta")
	@SequenceGenerator(
	    name = "generator_tarjeta", 
	    sequenceName = "T_TARJETA_TAR_N_ID_SEQ", 
	    allocationSize = 1
	)
	@Column(name = "TAR_N_ID")
	private int TAR_N_ID;
	
    @Column(name = "TAR_V_NUMERO")
    @JsonProperty("TAR_V_NUMERO")
    private String TAR_V_NUMERO;

    @Column(name = "TAR_D_FECHA_EMISION")
    @Temporal(TemporalType.DATE)
    @JsonProperty("TAR_D_FECHA_EMISION")
    private Date TAR_D_FECHA_EMISION;

    @Column(name = "TAR_D_FECHA_VENCIMIENTO")
    @Temporal(TemporalType.DATE)
    @JsonProperty("TAR_D_FECHA_VENCIMIENTO")
    private Date TAR_D_FECHA_VENCIMIENTO;

    @Column(name = "TAR_C_CVV")
    @JsonProperty("TAR_C_CVV")
    private String TAR_C_CVV;

    @Column(name = "TAR_V_ESTADO")
    @JsonProperty("TAR_V_ESTADO")
    private String TAR_V_ESTADO;

    @Column(name = "TAR_N_SALDO")
    @JsonProperty("TAR_N_SALDO")
    private double TAR_N_SALDO;

    @Column(name = "TAR_V_NUMERO_EMISION")
    @JsonProperty("TAR_V_NUMERO_EMISION")
    private String TAR_V_NUMERO_EMISION;

    @ManyToOne
    @JoinColumn(name = "CUE_N_ID")
    @JsonProperty("cuentaBancaria")
    private T_CUENTA_BANCARIA cuentaBancaria;

    @ManyToOne
    @JoinColumn(name = "TTJ_N_ID")
    @JsonProperty("tipoTarjeta")
    private CAT_TIPO_TARJETA tipoTarjeta;

    @ManyToOne
    @JoinColumn(name = "MAR_N_ID")
    @JsonProperty("marcaTarjeta")
    private CAT_MARCA_TARJETA marcaTarjeta;

    public T_TARJETA() {}

    public T_TARJETA(int TAR_N_ID, String TAR_V_NUMERO, Date TAR_D_FECHA_EMISION, 
                     Date TAR_D_FECHA_VENCIMIENTO, String TAR_C_CVV, String TAR_V_ESTADO, 
                     double TAR_N_SALDO, String TAR_V_NUMERO_EMISION, 
                     T_CUENTA_BANCARIA cuentaBancaria, CAT_TIPO_TARJETA tipoTarjeta, 
                     CAT_MARCA_TARJETA marcaTarjeta) {
        this.TAR_N_ID = TAR_N_ID;
        this.TAR_V_NUMERO = TAR_V_NUMERO;
        this.TAR_D_FECHA_EMISION = TAR_D_FECHA_EMISION;
        this.TAR_D_FECHA_VENCIMIENTO = TAR_D_FECHA_VENCIMIENTO;
        this.TAR_C_CVV = TAR_C_CVV;
        this.TAR_V_ESTADO = TAR_V_ESTADO;
        this.TAR_N_SALDO = TAR_N_SALDO;
        this.TAR_V_NUMERO_EMISION = TAR_V_NUMERO_EMISION;
        this.cuentaBancaria = cuentaBancaria;
        this.tipoTarjeta = tipoTarjeta;
        this.marcaTarjeta = marcaTarjeta;
    }

    public int getTAR_N_ID() { return TAR_N_ID; }
    public void setTAR_N_ID(int tAR_N_ID) { TAR_N_ID = tAR_N_ID; }

    public String getTAR_V_NUMERO() { return TAR_V_NUMERO; }
    public void setTAR_V_NUMERO(String tAR_V_NUMERO) { TAR_V_NUMERO = tAR_V_NUMERO; }

    public Date getTAR_D_FECHA_EMISION() { return TAR_D_FECHA_EMISION; }
    public void setTAR_D_FECHA_EMISION(Date tAR_D_FECHA_EMISION) { TAR_D_FECHA_EMISION = tAR_D_FECHA_EMISION; }

    public Date getTAR_D_FECHA_VENCIMIENTO() { return TAR_D_FECHA_VENCIMIENTO; }
    public void setTAR_D_FECHA_VENCIMIENTO(Date tAR_D_FECHA_VENCIMIENTO) { TAR_D_FECHA_VENCIMIENTO = tAR_D_FECHA_VENCIMIENTO; }

    public String getTAR_C_CVV() { return TAR_C_CVV; }
    public void setTAR_C_CVV(String tAR_C_CVV) { TAR_C_CVV = tAR_C_CVV; }

    public String getTAR_V_ESTADO() { return TAR_V_ESTADO; }
    public void setTAR_V_ESTADO(String tAR_V_ESTADO) { TAR_V_ESTADO = tAR_V_ESTADO; }

    public double getTAR_N_SALDO() { return TAR_N_SALDO; }
    public void setTAR_N_SALDO(double tAR_N_SALDO) { TAR_N_SALDO = tAR_N_SALDO; }

    public String getTAR_V_NUMERO_EMISION() { return TAR_V_NUMERO_EMISION; }
    public void setTAR_V_NUMERO_EMISION(String tAR_V_NUMERO_EMISION) { TAR_V_NUMERO_EMISION = tAR_V_NUMERO_EMISION; }

    public T_CUENTA_BANCARIA getCuentaBancaria() { return cuentaBancaria; }
    public void setCuentaBancaria(T_CUENTA_BANCARIA cuentaBancaria) { this.cuentaBancaria = cuentaBancaria; }

    public CAT_TIPO_TARJETA getTipoTarjeta() { return tipoTarjeta; }
    public void setTipoTarjeta(CAT_TIPO_TARJETA tipoTarjeta) { this.tipoTarjeta = tipoTarjeta; }

    public CAT_MARCA_TARJETA getMarcaTarjeta() { return marcaTarjeta; }
    public void setMarcaTarjeta(CAT_MARCA_TARJETA marcaTarjeta) { this.marcaTarjeta = marcaTarjeta; }
}