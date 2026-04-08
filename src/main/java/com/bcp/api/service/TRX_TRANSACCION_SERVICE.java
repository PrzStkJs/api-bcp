package com.bcp.api.service;

import java.util.List;

import com.bcp.api.dto.MovimientoDTO;
import com.bcp.api.model.TRX_TRANSACCION;

public interface TRX_TRANSACCION_SERVICE {
    List<TRX_TRANSACCION> listarTodas();
    TRX_TRANSACCION guardar(TRX_TRANSACCION transaccion);
    
    List<MovimientoDTO> listarMovimientosPorCuenta(String numeroCuenta);
}