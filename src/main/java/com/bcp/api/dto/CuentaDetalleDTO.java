package com.bcp.api.dto;

public class CuentaDetalleDTO {
	public Integer CUE_N_ID;
    public String CUE_V_NUMERO;
    public Double CUE_N_SALDO;
    public String TAR_V_NUMERO;
    public String TAR_V_ESTADO;
    public Integer TIPO_CUENTA; //  1 = Ahorro, 2 = Corriente

    public CuentaDetalleDTO() {}
}