package com.bcp.api.dto;

import java.util.List;

public class HomeResumenDTO {

    public Integer per_n_id; 
    
    public String CLI_V_NOMBRE;
    public String CUE_V_NUMERO;
    public Double CUE_N_SALDO;
    public String TAR_V_NUMERO;
    public String TAR_V_ESTADO;
    public List<CuentaDetalleDTO> cuentas;
    public List<MovimientoResumenDTO> movimientos;

    public HomeResumenDTO() {}
}