package com.bcp.api.model;

import jakarta.persistence.*;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "T_PRESTAMO")
public class T_PRESTAMO {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pre_generator")
    @SequenceGenerator(
        name = "pre_generator", 
        sequenceName = "T_PRESTAMO_PRE_N_ID_SEQ",
        allocationSize = 1
    )
    @Column(name = "PRE_N_ID")
    @JsonProperty("PRE_N_ID")
    private int PRE_N_ID;

    @Column(name = "PRE_N_MONTO")
    @JsonProperty("PRE_N_MONTO")
    private double PRE_N_MONTO;

    @Column(name = "PRE_N_TASA_INTERES")
    @JsonProperty("PRE_N_TASA_INTERES")
    private double PRE_N_TASA_INTERES;

    @Column(name = "PRE_N_PLAZO_MESES")
    @JsonProperty("PRE_N_PLAZO_MESES")
    private int PRE_N_PLAZO_MESES;

    @Column(name = "PRE_D_FECHA_INICIO")
    @Temporal(TemporalType.DATE)
    @JsonProperty("PRE_D_FECHA_INICIO")
    private Date PRE_D_FECHA_INICIO;

    @Column(name = "PRE_D_FECHA_VENCIMIENTO")
    @Temporal(TemporalType.DATE)
    @JsonProperty("PRE_D_FECHA_VENCIMIENTO")
    private Date PRE_D_FECHA_VENCIMIENTO;

    @Column(name = "PRE_V_ESTADO")
    @JsonProperty("PRE_V_ESTADO")
    private String PRE_V_ESTADO;

    @Column(name = "PRE_N_CUOTA_MENSUAL")
    @JsonProperty("PRE_N_CUOTA_MENSUAL")
    private double PRE_N_CUOTA_MENSUAL;

    @Column(name = "PRE_V_GARANTIA")
    @JsonProperty("PRE_V_GARANTIA")
    private String PRE_V_GARANTIA;
    
    @ManyToOne
    @JoinColumn(name = "CLI_N_ID")
    @JsonProperty("cliente")
    private T_CLIENTE cliente;

    @ManyToOne
    @JoinColumn(name = "TPR_N_ID")
    @JsonProperty("tipoPrestamo")
    private CAT_TIPO_PRESTAMO tipoPrestamo;

    @ManyToOne
    @JoinColumn(name = "MON_N_ID")
    @JsonProperty("moneda")
    private CAT_MONEDA moneda;

    public T_PRESTAMO() {}

    public T_PRESTAMO(int PRE_N_ID, double PRE_N_MONTO, double PRE_N_TASA_INTERES, int PRE_N_PLAZO_MESES, 
                      Date PRE_D_FECHA_INICIO, Date PRE_D_FECHA_VENCIMIENTO, String PRE_V_ESTADO, 
                      double PRE_N_CUOTA_MENSUAL, String PRE_V_GARANTIA, T_CLIENTE cliente, 
                      CAT_TIPO_PRESTAMO tipoPrestamo, CAT_MONEDA moneda) {
        this.PRE_N_ID = PRE_N_ID;
        this.PRE_N_MONTO = PRE_N_MONTO;
        this.PRE_N_TASA_INTERES = PRE_N_TASA_INTERES;
        this.PRE_N_PLAZO_MESES = PRE_N_PLAZO_MESES;
        this.PRE_D_FECHA_INICIO = PRE_D_FECHA_INICIO;
        this.PRE_D_FECHA_VENCIMIENTO = PRE_D_FECHA_VENCIMIENTO;
        this.PRE_V_ESTADO = PRE_V_ESTADO;
        this.PRE_N_CUOTA_MENSUAL = PRE_N_CUOTA_MENSUAL;
        this.PRE_V_GARANTIA = PRE_V_GARANTIA;
        this.cliente = cliente;
        this.tipoPrestamo = tipoPrestamo;
        this.moneda = moneda;
    }

    public int getPRE_N_ID() { return PRE_N_ID; }
    public void setPRE_N_ID(int pRE_N_ID) { PRE_N_ID = pRE_N_ID; }

    public double getPRE_N_MONTO() { return PRE_N_MONTO; }
    public void setPRE_N_MONTO(double pRE_N_MONTO) { PRE_N_MONTO = pRE_N_MONTO; }

    public double getPRE_N_TASA_INTERES() { return PRE_N_TASA_INTERES; }
    public void setPRE_N_TASA_INTERES(double pRE_N_TASA_INTERES) { PRE_N_TASA_INTERES = pRE_N_TASA_INTERES; }

    public int getPRE_N_PLAZO_MESES() { return PRE_N_PLAZO_MESES; }
    public void setPRE_N_PLAZO_MESES(int pRE_N_PLAZO_MESES) { PRE_N_PLAZO_MESES = pRE_N_PLAZO_MESES; }

    public Date getPRE_D_FECHA_INICIO() { return PRE_D_FECHA_INICIO; }
    public void setPRE_D_FECHA_INICIO(Date pRE_D_FECHA_INICIO) { PRE_D_FECHA_INICIO = pRE_D_FECHA_INICIO; }

    public Date getPRE_D_FECHA_VENCIMIENTO() { return PRE_D_FECHA_VENCIMIENTO; }
    public void setPRE_D_FECHA_VENCIMIENTO(Date pRE_D_FECHA_VENCIMIENTO) { PRE_D_FECHA_VENCIMIENTO = pRE_D_FECHA_VENCIMIENTO; }

    public String getPRE_V_ESTADO() { return PRE_V_ESTADO; }
    public void setPRE_V_ESTADO(String pRE_V_ESTADO) { PRE_V_ESTADO = pRE_V_ESTADO; }

    public double getPRE_N_CUOTA_MENSUAL() { return PRE_N_CUOTA_MENSUAL; }
    public void setPRE_N_CUOTA_MENSUAL(double pRE_N_CUOTA_MENSUAL) { PRE_N_CUOTA_MENSUAL = pRE_N_CUOTA_MENSUAL; }

    public String getPRE_V_GARANTIA() { return PRE_V_GARANTIA; }
    public void setPRE_V_GARANTIA(String pRE_V_GARANTIA) { PRE_V_GARANTIA = pRE_V_GARANTIA; }

    public T_CLIENTE getCliente() { return cliente; }
    public void setCliente(T_CLIENTE cliente) { this.cliente = cliente; }

    public CAT_TIPO_PRESTAMO getTipoPrestamo() { return tipoPrestamo; }
    public void setTipoPrestamo(CAT_TIPO_PRESTAMO tipoPrestamo) { this.tipoPrestamo = tipoPrestamo; }

    public CAT_MONEDA getMoneda() { return moneda; }
    public void setMoneda(CAT_MONEDA moneda) { this.moneda = moneda; }
}