package com.bcp.api.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List; // 🔥 IMPORTANTE: Agregar esto
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "T_CUENTA_BANCARIA")
public class T_CUENTA_BANCARIA {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cta_seq")
	@SequenceGenerator(name = "cta_seq", sequenceName = "T_CUENTA_BANCARIA_CUE_N_ID_SEQ", allocationSize = 1)
	@Column(name = "CUE_N_ID")
	@JsonProperty("CUE_N_ID")
	private int CUE_N_ID;

    @Column(name = "CUE_V_NUMERO")
    @JsonProperty("CUE_V_NUMERO")
    private String CUE_V_NUMERO;

    @Column(name = "CUE_N_SALDO")
    @JsonProperty("CUE_N_SALDO")
    private double CUE_N_SALDO;

    @Column(name = "CUE_D_FECHA_CREACION")
    @Temporal(TemporalType.DATE) 
    @JsonProperty("CUE_D_FECHA_CREACION")
    private Date CUE_D_FECHA_CREACION;

    @Column(name = "CUE_V_ESTADO")
    @JsonProperty("CUE_V_ESTADO")
    private String CUE_V_ESTADO;
    
    @ManyToOne
    @JoinColumn(name = "CLI_N_ID")
    @JsonProperty("cliente")
    private T_CLIENTE cliente;

    @ManyToOne
    @JoinColumn(name = "TCB_N_ID")
    @JsonProperty("tipoCuentaBancaria")
    private CAT_TIPO_CUENTA_BANCARIA tipoCuentaBancaria;

    @ManyToOne
    @JoinColumn(name = "MON_N_ID")
    @JsonProperty("moneda")
    private CAT_MONEDA moneda;

    // 🔥 RELACIÓN CLAVE: Esto conecta la Cuenta con la Tarjeta en Java
    // Usamos EAGER para que cargue la tarjeta de inmediato y no de error en el Service
    @OneToMany(mappedBy = "cuentaBancaria", fetch = FetchType.EAGER)
    @JsonProperty("tarjetas")
    private List<T_TARJETA> tarjetas;

    public T_CUENTA_BANCARIA() {}

    public T_CUENTA_BANCARIA(int CUE_N_ID, String CUE_V_NUMERO, double CUE_N_SALDO, 
                             Date CUE_D_FECHA_CREACION, String CUE_V_ESTADO, 
                             T_CLIENTE cliente, CAT_TIPO_CUENTA_BANCARIA tipoCuentaBancaria, 
                             CAT_MONEDA moneda) {
        this.CUE_N_ID = CUE_N_ID;
        this.CUE_V_NUMERO = CUE_V_NUMERO;
        this.CUE_N_SALDO = CUE_N_SALDO;
        this.CUE_D_FECHA_CREACION = CUE_D_FECHA_CREACION;
        this.CUE_V_ESTADO = CUE_V_ESTADO;
        this.cliente = cliente;
        this.tipoCuentaBancaria = tipoCuentaBancaria;
        this.moneda = moneda;
    }

    // --- GETTERS Y SETTERS ---

    public int getCUE_N_ID() { return CUE_N_ID; }
    public void setCUE_N_ID(int cUE_N_ID) { CUE_N_ID = cUE_N_ID; }

    public String getCUE_V_NUMERO() { return CUE_V_NUMERO; }
    public void setCUE_V_NUMERO(String cUE_V_NUMERO) { CUE_V_NUMERO = cUE_V_NUMERO; }

    public double getCUE_N_SALDO() { return CUE_N_SALDO; }
    public void setCUE_N_SALDO(double cUE_N_SALDO) { CUE_N_SALDO = cUE_N_SALDO; }

    public Date getCUE_D_FECHA_CREACION() { return CUE_D_FECHA_CREACION; }
    public void setCUE_D_FECHA_CREACION(Date cUE_D_FECHA_CREACION) { CUE_D_FECHA_CREACION = cUE_D_FECHA_CREACION; }

    public String getCUE_V_ESTADO() { return CUE_V_ESTADO; }
    public void setCUE_V_ESTADO(String cUE_V_ESTADO) { CUE_V_ESTADO = cUE_V_ESTADO; }

    public T_CLIENTE getCliente() { return cliente; }
    public void setCliente(T_CLIENTE cliente) { this.cliente = cliente; }

    public CAT_TIPO_CUENTA_BANCARIA getTipoCuentaBancaria() { return tipoCuentaBancaria; }
    public void setTipoCuentaBancaria(CAT_TIPO_CUENTA_BANCARIA tipoCuentaBancaria) { this.tipoCuentaBancaria = tipoCuentaBancaria; }

    public CAT_MONEDA getMoneda() { return moneda; }
    public void setMoneda(CAT_MONEDA moneda) { this.moneda = moneda; }

    // 🔥 GETTER PARA LAS TARJETAS (Indispensable para el Service)
    public List<T_TARJETA> getTarjetas() { return tarjetas; }
    public void setTarjetas(List<T_TARJETA> tarjetas) { this.tarjetas = tarjetas; }
}