package com.bcp.api.model;

import jakarta.persistence.*;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "TRX_TRANSACCION")
public class TRX_TRANSACCION {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trx_seq")
    @SequenceGenerator(name = "trx_seq", sequenceName = "TRX_TRANSACCION_TRX_N_ID_SEQ", allocationSize = 1)
    @Column(name = "TRX_N_ID")
    @JsonProperty("TRX_N_ID")
    private int TRX_N_ID;

    @Column(name = "TRX_N_MONTO")
    @JsonProperty("TRX_N_MONTO")
    private double TRX_N_MONTO;

    @Column(name = "TRX_D_FECHA_HORA")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonProperty("TRX_D_FECHA_HORA")
    private Date TRX_D_FECHA_HORA;

    @Column(name = "TRX_V_REFERENCIA")
    @JsonProperty("TRX_V_REFERENCIA")
    private String TRX_V_REFERENCIA;

    @Column(name = "TRX_V_ESTADO")
    @JsonProperty("TRX_V_ESTADO")
    private String TRX_V_ESTADO;

    @ManyToOne
    @JoinColumn(name = "TTX_N_ID")
    @JsonProperty("tipoTransaccion")
    private CAT_TIPO_TRANSACCION tipoTransaccion;

    @ManyToOne
    @JoinColumn(name = "MON_N_ID")
    @JsonProperty("moneda")
    private CAT_MONEDA moneda;

    @ManyToOne
    @JoinColumn(name = "ID_DESTINO")
    @JsonProperty("cuentaDestino")
    private T_CUENTA_BANCARIA cuentaDestino;

    @ManyToOne
    @JoinColumn(name = "STX_N_ID")
    @JsonProperty("servicioTransaccion")
    private CAT_SERVICIO_TRANSACCION servicioTransaccion;

    @ManyToOne
    @JoinColumn(name = "MOP_N_ID")
    @JsonProperty("medioOperacion")
    private CAT_MEDIO_OPERACION medioOperacion;

    @ManyToOne
    @JoinColumn(name = "ID_ORIGEN")
    @JsonProperty("cuentaOrigen")
    private T_CUENTA_BANCARIA cuentaOrigen;

    public TRX_TRANSACCION() {}

    public TRX_TRANSACCION(int TRX_N_ID, double TRX_N_MONTO, Date TRX_D_FECHA_HORA, 
                           String TRX_V_REFERENCIA, String TRX_V_ESTADO, 
                           CAT_TIPO_TRANSACCION tipoTransaccion, CAT_MONEDA moneda, 
                           T_CUENTA_BANCARIA cuentaDestino, 
                           CAT_SERVICIO_TRANSACCION servicioTransaccion, 
                           CAT_MEDIO_OPERACION medioOperacion, T_CUENTA_BANCARIA cuentaOrigen) {
        this.TRX_N_ID = TRX_N_ID;
        this.TRX_N_MONTO = TRX_N_MONTO;
        this.TRX_D_FECHA_HORA = TRX_D_FECHA_HORA;
        this.TRX_V_REFERENCIA = TRX_V_REFERENCIA;
        this.TRX_V_ESTADO = TRX_V_ESTADO;
        this.tipoTransaccion = tipoTransaccion;
        this.moneda = moneda;
        this.cuentaDestino = cuentaDestino;
        this.servicioTransaccion = servicioTransaccion;
        this.medioOperacion = medioOperacion;
        this.cuentaOrigen = cuentaOrigen;
    }

    // Getters y Setters
    public int getTRX_N_ID() { return TRX_N_ID; }
    public void setTRX_N_ID(int tRX_N_ID) { TRX_N_ID = tRX_N_ID; }
    public double getTRX_N_MONTO() { return TRX_N_MONTO; }
    public void setTRX_N_MONTO(double tRX_N_MONTO) { TRX_N_MONTO = tRX_N_MONTO; }
    public Date getTRX_D_FECHA_HORA() { return TRX_D_FECHA_HORA; }
    public void setTRX_D_FECHA_HORA(Date tRX_D_FECHA_HORA) { TRX_D_FECHA_HORA = tRX_D_FECHA_HORA; }
    public String getTRX_V_REFERENCIA() { return TRX_V_REFERENCIA; }
    public void setTRX_V_REFERENCIA(String tRX_V_REFERENCIA) { TRX_V_REFERENCIA = tRX_V_REFERENCIA; }
    public String getTRX_V_ESTADO() { return TRX_V_ESTADO; }
    public void setTRX_V_ESTADO(String tRX_V_ESTADO) { TRX_V_ESTADO = tRX_V_ESTADO; }
    public CAT_TIPO_TRANSACCION getTipoTransaccion() { return tipoTransaccion; }
    public void setTipoTransaccion(CAT_TIPO_TRANSACCION tipoTransaccion) { this.tipoTransaccion = tipoTransaccion; }
    public CAT_MONEDA getMoneda() { return moneda; }
    public void setMoneda(CAT_MONEDA moneda) { this.moneda = moneda; }
    public T_CUENTA_BANCARIA getCuentaDestino() { return cuentaDestino; }
    public void setCuentaDestino(T_CUENTA_BANCARIA cuentaDestino) { this.cuentaDestino = cuentaDestino; }
    public CAT_SERVICIO_TRANSACCION getServicioTransaccion() { return servicioTransaccion; }
    public void setServicioTransaccion(CAT_SERVICIO_TRANSACCION servicioTransaccion) { this.servicioTransaccion = servicioTransaccion; }
    public CAT_MEDIO_OPERACION getMedioOperacion() { return medioOperacion; }
    public void setMedioOperacion(CAT_MEDIO_OPERACION medioOperacion) { this.medioOperacion = medioOperacion; }
    public T_CUENTA_BANCARIA getCuentaOrigen() { return cuentaOrigen; }
    public void setCuentaOrigen(T_CUENTA_BANCARIA cuentaOrigen) { this.cuentaOrigen = cuentaOrigen; }
}