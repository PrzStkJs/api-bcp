package com.bcp.api.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "TCB_MONEDA")
@IdClass(TCB_MONEDA_ID.class)
public class TCB_MONEDA {

    @Id
    @ManyToOne
    @JoinColumn(name = "TCB_N_ID") 
    @JsonProperty("tipoCuentaBancaria")
    private CAT_TIPO_CUENTA_BANCARIA tipoCuentaBancaria;

    @Id
    @ManyToOne
    @JoinColumn(name = "MON_N_ID") 
    @JsonProperty("moneda")
    private CAT_MONEDA moneda;

    public TCB_MONEDA() {}

    public TCB_MONEDA(CAT_TIPO_CUENTA_BANCARIA tipoCuentaBancaria, CAT_MONEDA moneda) {
        this.tipoCuentaBancaria = tipoCuentaBancaria;
        this.moneda = moneda;
    }

    public CAT_TIPO_CUENTA_BANCARIA getTipoCuentaBancaria() { return tipoCuentaBancaria; }
    public void setTipoCuentaBancaria(CAT_TIPO_CUENTA_BANCARIA tipoCuentaBancaria) { this.tipoCuentaBancaria = tipoCuentaBancaria; }

    public CAT_MONEDA getMoneda() { return moneda; }
    public void setMoneda(CAT_MONEDA moneda) { this.moneda = moneda; }
}